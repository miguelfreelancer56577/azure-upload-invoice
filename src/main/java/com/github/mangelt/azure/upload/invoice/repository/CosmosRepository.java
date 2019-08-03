package com.github.mangelt.azure.upload.invoice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.azure.data.cosmos.internal.AsyncDocumentClient;
import com.azure.data.cosmos.internal.Document;
import com.azure.data.cosmos.internal.RequestOptions;
import com.azure.data.cosmos.internal.ResourceResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public abstract class CosmosRepository <T,I>{
	
	@Autowired
	protected AsyncDocumentClient client;
	
	@Autowired
	@Qualifier("containerLink")
	protected String containerLink;
	
	
	public Flux<ResourceResponse<Document>> save(T document) {
		return client.createDocument(containerLink, document, null, true);
    }

}
