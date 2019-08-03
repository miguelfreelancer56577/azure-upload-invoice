package com.github.mangelt.azure.upload.invoice.repository;

import org.springframework.stereotype.Component;

import com.github.mangelt.azure.upload.invoice.model.Comprobante;

@Component
public class ComprobateRepository extends CosmosRepository<Comprobante, String> {

}
