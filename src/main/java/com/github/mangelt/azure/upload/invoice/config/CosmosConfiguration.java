package com.github.mangelt.azure.upload.invoice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.azure.data.cosmos.ConnectionPolicy;
import com.azure.data.cosmos.ConsistencyLevel;
import com.azure.data.cosmos.internal.AsyncDocumentClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CosmosConfiguration{

	@Value("${application.cosmosdb.accountHost}")
    private String accountHost;

    @Value("${application.cosmosdb.accountKey}")
    private String accountKey;
    
    @Value("${application.cosmosdb.databaseName}")
    private String databaseName;
    @Value("${application.cosmosdb.containerName}")
    private String containerName;
    
    @Bean
    public AsyncDocumentClient asyncDocumentClient() {
    	return new AsyncDocumentClient
        		.Builder()
        		.withServiceEndpoint(accountHost)
        		.withMasterKeyOrResourceToken(accountKey)
        		.withConnectionPolicy(ConnectionPolicy.defaultPolicy())
        		.withConsistencyLevel(ConsistencyLevel.EVENTUAL)
        		.build();
    }

    @Bean
    protected String containerLink() {
    	return "dbs/" + databaseName + "/colls/" + containerName;
    }
	
}
