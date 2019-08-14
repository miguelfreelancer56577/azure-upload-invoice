package com.github.mangelt.azure.upload.invoice.repository;

import hu.akarnokd.rxjava.interop.RxJavaInterop;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;

import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.cosmosdb.ResourceResponse;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;

@Repository
public abstract class CosmosRepository <T,I>{
	
	@Autowired
	protected AsyncDocumentClient client;
	
	@Autowired
	@Qualifier("containerLink")
	protected String containerLink;
	
	
	public Flux<ResourceResponse<Document>> save(T document) {
		rx.Observable<ResourceResponse<Document>>  oldObs = client.createDocument(containerLink, document, null, true);
		io.reactivex.Observable<ResourceResponse<Document>> newObs = RxJavaInterop.toV2Observable(oldObs);
		return RxJava2Adapter.observableToFlux(newObs, io.reactivex.BackpressureStrategy.BUFFER);
    }

}
