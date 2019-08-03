package com.github.mangelt.azure.upload.invoice.repository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.azure.data.cosmos.internal.Document;
import com.github.mangelt.azure.upload.invoice.components.XmlReader;
import com.github.mangelt.azure.upload.invoice.exception.XmlReaderException;
import com.github.mangelt.azure.upload.invoice.model.Comprobante;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

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
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Before
	public void setup() {
		if(cache.isEmpty()) {
			List<File> files = new ArrayList<File>();
			cache.put("files", files);
			
			try
			{
				Files.list(Paths.get(resourceLoader.getResource(this.recourceDir).getFile().getPath()))
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
		
		List<File> files = (List<File>) cache.get("files");
		
		files.forEach(file->{
			
			Comprobante comp;
			
			try {
				comp = xmlReader.createComprobante(file);
				comp.setId(UUID.randomUUID().toString());
				
				Document doc = repo.save(comp)
						.flatMap(res->Mono.just(res.getResource()))
						.blockFirst();
						
				log.info(doc.toJson());
				
			} catch (XmlReaderException e) {
				log.error(e.getMessage());
			}

		});
			
	}
	
}
