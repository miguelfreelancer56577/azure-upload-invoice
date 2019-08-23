package com.github.mangelt.azure.upload.invoice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@Slf4j
public class App 
{
    public static void main( String[] args )
    {
    	log.info("Running azure-upload-invoice applicastion: " + App.class.getName());
    	SpringApplication.run(App.class, args);
    }
    
}
