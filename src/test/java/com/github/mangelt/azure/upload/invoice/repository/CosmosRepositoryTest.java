package com.github.mangelt.azure.upload.invoice.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.azure.data.cosmos.internal.Document;
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
	
	@Before
	public void setup() {
		if(cache.isEmpty()) {
			Comprobante comprobante = new Comprobante();
			comprobante.setId(UUID.randomUUID().toString());
			comprobante.setCertificado(UUID.randomUUID().toString());
			cache.put("comprobante", comprobante);
		}
	} 
	
	@Test
	public void createComp() {
		
		Comprobante comp = (Comprobante)cache.get("comprobante");
		
		Document doc = repo.save(comp)
		.flatMap(res->Mono.just(res.getResource()))
		.blockFirst();
		
		log.info(doc.toJson());
	}
	
}
