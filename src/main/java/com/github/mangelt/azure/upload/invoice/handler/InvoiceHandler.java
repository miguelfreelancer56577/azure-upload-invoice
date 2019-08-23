package com.github.mangelt.azure.upload.invoice.handler;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mangelt.azure.upload.invoice.components.XmlReader;
import com.github.mangelt.azure.upload.invoice.exception.XmlReaderException;
import com.github.mangelt.azure.upload.invoice.repository.ComprobateRepository;
import com.github.mangelt.azure.upload.invoice.util.XmlWrapperFile;
import com.github.mangelt.sat.services.blob.StorageResource;
import com.github.mangelt.sat.services.model.Comprobante;
import com.github.mangelt.sat.services.util.BlobException;
import com.github.mangelt.sat.services.util.BlobUtil;
import com.github.mangelt.sat.services.util.ErrorUtil;
import com.github.mangelt.sat.services.util.FileUtil;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

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
						log.error(errorUtil.errorMessage(bte));
						return BlobUtil.onErrorResponse(bte);
					}

					Flux<File> xmlFiles = fileUtil.streamFrom(compressFile).log();
					
					Flux<Comprobante> comprobantes = xmlFiles.flatMap(xmlFile->{
						
						XmlWrapperFile xmlWrapperFile = new XmlWrapperFile(false, xmlFile, null);
						
						try {
							
							Comprobante comprobante = xmlReader.createComprobante(xmlFile);
							comprobante.setId(comprobante.getComplemento().getTimbreFiscalDigital().getUUID());
							xmlWrapperFile.setComprobante(comprobante);
							xmlWrapperFile.setProcessed(true);
							
							log.info("Transformed File: {}", comprobante.toString());
							
						} catch (XmlReaderException e) {
							
							try {
								
								StorageResource sr = new StorageResource(this.blobContainer);
								
								sr.setCloudBlockBlob(compressFile.getName());
								
								log.error("Error while trying to transform {} to comprobante, uploading file to blob container", compressFile.getName());
								sr.uploadFromFile(xmlFile);
								
							} catch (StorageException | IOException bw) {
								log.error("There was an error to upload blob file with error: {}", errorUtil.errorMessage(bw));
							}
							log.error("There was an error to get a Comprobante from the File: " + xmlFile.getName());
							log.error("ERROR CLASS: {} ERROR CAUSE: {}", e.getClass() , e.getCause() );
						}
						
						return Mono.just(xmlWrapperFile);
						
					})
					.filter(xmlWrapperFile->xmlWrapperFile.processed)
					.flatMap(xmlWrapperFile->Mono.just(xmlWrapperFile.getComprobante()))
					.flatMap(comprobante->repo.getById(comprobante.getId())
							.switchIfEmpty(repo.save(comprobante, true))
							.flatMap(oldComp->repo.update(comprobante, true)));
					
					return comprobantes.last()
								.flatMap(comprobante->ServerResponse.ok()
														.build())
								.onErrorResume(error->{
									log.error(errorUtil.errorMessage(error));
									return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Mono.just(errorUtil.errorMessage(error)), String.class);
								});

				});
	}
	
}
