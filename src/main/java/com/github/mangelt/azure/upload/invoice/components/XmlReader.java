package com.github.mangelt.azure.upload.invoice.components;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.github.mangelt.azure.upload.invoice.exception.XmlReaderException;
import com.github.mangelt.sat.services.model.Comprobante;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class XmlReader {
	
	@Autowired
	@NonNull
	InvoiceCleaner invoiceCleaner;

	public Comprobante createComprobante(File invoiceFile) throws XmlReaderException {
		
		log.info("Concurrent invoice: {}", invoiceFile.getName());
		
		Comprobante comprobante = null;
		
		try {
			invoiceCleaner.cleanup(invoiceFile);
			JAXBContext jc = JAXBContext.newInstance( "com.github.mangelt.sat.services.model" );
			Unmarshaller u = jc.createUnmarshaller();		
			comprobante = (Comprobante)u.unmarshal(invoiceFile);
			return comprobante;
		} catch (Exception e) {
			log.error("Unmarshall Error: {}", e.getMessage());
			throw new XmlReaderException(e);
		}
	}
	
}
