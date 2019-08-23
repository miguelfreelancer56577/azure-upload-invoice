package com.github.mangelt.azure.upload.invoice.handler;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
import com.github.mangelt.sat.services.util.FileUtil;
import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

@Slf4j
//@Component
public class InvoiceHandler {

	@Autowired
	protected CloudBlobContainer blobContainer;
	
	@Autowired
	FileUtil fileUtil;
	
	@Autowired
	XmlReader xmlReader;
	
	@Autowired
	ComprobateRepository repo;

	protected ObjectMapper mapper = new ObjectMapper();
	
	public Mono<ServerResponse> uploadCosmos(ServerRequest rq)
	{
		String fileName = rq.pathVariable("filename");

		log.info("FILE NAME {}", fileName);

		StorageResource sr = new StorageResource(this.blobContainer);

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
					try
					{
						if (bte.getStatus() != null)
						{
							return BlobUtil.onErrorResponse(bte);
						}

						BlobUtil.isValidFile(fileName, compressFile);
						
						Flux<File> xmlFiles = fileUtil.streamFrom(compressFile).log();
						
						xmlFiles.flatMap(xmlFile->{
							
							XmlWrapperFile xmlWrapperFile = new XmlWrapperFile(false, xmlFile, null);
							
							try {
								
								Comprobante comprobante = xmlReader.createComprobante(xmlFile);
								comprobante.setId(UUID.randomUUID().toString());
								xmlWrapperFile.setComprobante(comprobante);
								xmlWrapperFile.setProcessed(true);
								
							} catch (XmlReaderException e) {
								
								sr.setCloudBlockBlob(compressFile.getName());
								try {
									sr.uploadFromFile(xmlFile);
								} catch (StorageException | IOException blobException) {
									
								}
								
								log.error("There was an error to get a Comprobante from the File: " + xmlFile.getName());
								log.error("ERROR CLASS: {} ERROR CAUSE: {}", e.getClass() , e.getCause() );
								
							}
							
							return Mono.just(xmlWrapperFile);
							
						})
						.filter(xmlWrapperFile->xmlWrapperFile.processed)
						.flatMap(xmlWrapperFile->Mono.just(xmlWrapperFile.getComprobante()))
						.flatMap(comprobante->repo.save(comprobante).flatMap(response->Mono.just(response.getResource())));

//						sr.uploadFromFile(file);
//						log.info("FILE UPLOADED SUCCESSFULLY {}", file);
//
						return ServerResponse.ok()
								.build();

					}
					catch (BlobException e)
					{
						return BlobUtil.onErrorResponse(e);
					}
//					catch (StorageException | IOException e)
//					{
//						return BlobUtil.onErrorResponse(new BlobException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
//					}
				});
	}
	
}
