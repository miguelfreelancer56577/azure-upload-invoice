package com.github.mangelt.azure.upload.invoice.repository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.github.mangelt.azure.upload.invoice.components.XmlReader;
import com.github.mangelt.azure.upload.invoice.exception.XmlReaderException;
import com.github.mangelt.azure.upload.invoice.util.XmlWrapperFile;
import com.github.mangelt.sat.services.model.Comprobante;
import com.github.mangelt.sat.services.util.FileUtil;
import com.microsoft.azure.cosmosdb.Document;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@Slf4j
public class CosmosRepositoryTest {

	public static Map<String, Object> cache = new HashMap<>();
	
	@Autowired
	ComprobateRepository repo;
	
	@Autowired
	XmlReader xmlReader;
	
	@Value("classpath:files/")
	String recourceDir;
	
	@Value("classpath:zip_files/")
	String zipFiles;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	FileUtil fileUtil;
	
	@Before
	public void setup() {
		if(cache.isEmpty()) {
			List<File> files = new ArrayList<File>();
			cache.put("zipFiles", files);
			
			try
			{
				Files.list(Paths.get(resourceLoader.getResource(this.zipFiles).getFile().getPath()))
				.forEach(path -> files.add(path.toFile()));
			}
			catch (Exception e)
			{
				log.error(e.getMessage());
			}
		}
	} 
	
	@Test
	public void createComp() {
		
		List<File> files = (List<File>)cache.get("zipFiles");
		File compressFile = files.get(0);
		
		Flux<File> xmlFiles = fileUtil.streamFrom(compressFile).log();
		
		Flux<Document> docs = xmlFiles.flatMap(xmlFile->{
			
			XmlWrapperFile xmlWrapperFile = new XmlWrapperFile(false, xmlFile, null);
			
			try {
				
				Comprobante comprobante = xmlReader.createComprobante(xmlFile);
				comprobante.setId(UUID.randomUUID().toString());
				xmlWrapperFile.setComprobante(comprobante);
				xmlWrapperFile.setProcessed(true);
				
			} catch (XmlReaderException e) {
				
				log.error("There was an error to get a Comprobante from the File: " + xmlFile.getName());
				log.error("ERROR CLASS: {} ERROR CAUSE: {}", e.getClass() , e.getCause() );
				
			}
			
			return Mono.just(xmlWrapperFile);
			
		})
		.filter(xmlWrapperFile->xmlWrapperFile.processed)
		.flatMap(xmlWrapperFile->Mono.just(xmlWrapperFile.getComprobante()))
		.flatMap(comprobante->repo.save(comprobante).flatMap(response->Mono.just(response.getResource())));
		
		docs.subscribe(doc->{
			log.info("Comprobante inserted in comos db with id: {}" , doc.get("id"));
		});
		
	}
	
}
