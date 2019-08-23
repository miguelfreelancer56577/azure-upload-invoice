package com.github.mangelt.azure.upload.invoice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.github.mangelt.azure.upload.invoice.handler.InvoiceHandler;

@Configuration
public class InvoiceRouter {

	public static String API = "/invoice-management";

	@Bean
	public RouterFunction<ServerResponse> blobItem(InvoiceHandler invoiceHandler)
	{
		return RouterFunctions
				.route(RequestPredicates.POST(API.concat("/upload")).and(RequestPredicates.accept(MediaType.MULTIPART_FORM_DATA)),
						invoiceHandler::uploadCosmos);
	}
	
}
