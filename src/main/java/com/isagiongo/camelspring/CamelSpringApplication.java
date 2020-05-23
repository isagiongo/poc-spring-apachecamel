package com.isagiongo.camelspring;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;

@SpringBootApplication
public class CamelSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelSpringApplication.class, args);
	}
}
