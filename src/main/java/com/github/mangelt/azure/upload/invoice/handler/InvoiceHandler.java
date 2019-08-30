package com.github.mangelt.azure.upload.invoice.handler;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.github.mangelt.azure.upload.invoice.components.XmlReader;
import com.github.mangelt.azure.upload.invoice.exception.XmlReaderException;
import com.github.mangelt.azure.upload.invoice.repository.ComprobateRepository;
import com.github.mangelt.azure.upload.invoice.util.XmlWrapperFile;
import com.github.mangelt.sat.services.blob.StorageResource;
import com.github.mangelt.sat.services.model.Comprobante;
import com.github.mangelt.sat.services.util.BlobException;
import com.github.mangelt.sat.services.util.BlobUtil;
import com.github.mangelt.sat.services.util.ErrorUtil;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

import ch.qos.logback.core.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class InvoiceHandler {

	@Autowired
	protected CloudBlobContainer blobContainer;

	@Autowired
	FileUtil fileUtil;

	@Autowired
	ErrorUtil errorUtil;

	@Autowired
	XmlReader xmlReader;

	@Autowired
	ComprobateRepository repo;

	public Mono<ServerResponse> uploadCosmos(ServerRequest rq)
	{

		BlobException bte = new BlobException();

		return rq.body(BodyExtractors.toMultipartData())
				.flatMap(BlobUtil::getFileFromMultipartData)
				.onErrorResume(e ->
				{
					BlobException returnedExcpetion = (BlobException)e;

					bte.setMessage(returnedExcpetion.getMessage());
					bte.setStatus(returnedExcpetion.getStatus());

					return Mono.just(new File(""));
				})
				.flatMap(compressFile ->
				{

					if (bte.getStatus() != null)
					{
						log.error(this.errorUtil.errorMessage(bte));
						return BlobUtil.onErrorResponse(bte);
					}

					Flux<File> xmlFiles = this.fileUtil.streamFrom(compressFile).log();

					Flux<Comprobante> comprobantes = xmlFiles.flatMap(xmlFile->{

						XmlWrapperFile xmlWrapperFile = new XmlWrapperFile(false, xmlFile, null);

						try {

							Comprobante comprobante = this.xmlReader.createComprobante(xmlFile);
							comprobante.setId(comprobante.getComplemento().getTimbreFiscalDigital().getUUID());
							xmlWrapperFile.setComprobante(comprobante);
							xmlWrapperFile.setProcessed(true);

							log.info("Transformed File: {}", comprobante.toString());

						} catch (XmlReaderException e) {

							try {

								StorageResource sr = new StorageResource(this.blobContainer);

								sr.setCloudBlockBlob(xmlFile.getName());

								log.error("Error while trying to transform {} to comprobante, uploading file to blob container", xmlFile.getName());
								sr.uploadFromFile(xmlFile);

							} catch (StorageException | IOException bw) {
								log.error("There was an error to upload blob file with error: {}", this.errorUtil.errorMessage(bw));
							}
							log.error("There was an error to get a Comprobante from the File: " + xmlFile.getName());
							log.error("ERROR CLASS: {} ERROR CAUSE: {}", e.getClass() , e.getMessage() );
						}

						return Mono.just(xmlWrapperFile);

					})
							.filter(xmlWrapperFile->xmlWrapperFile.processed)
							.flatMap(xmlWrapperFile->Mono.just(xmlWrapperFile.getComprobante()))
							.flatMap(comprobante->this.repo.getById(comprobante.getId())
									.switchIfEmpty(this.repo.save(comprobante, true))
									.flatMap(oldComp->this.repo.update(comprobante, true)));

					return comprobantes.last()
							.flatMap(comprobante->ServerResponse.ok()
									.build())
							.onErrorResume(error->{
								log.error(this.errorUtil.errorMessage(error));
								return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Mono.just(this.errorUtil.errorMessage(error)), String.class);
							});

				});
	}

}
