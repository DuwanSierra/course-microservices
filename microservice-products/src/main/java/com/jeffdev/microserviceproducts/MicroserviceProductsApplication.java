package com.jeffdev.microserviceproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.reactive.config.EnableWebFlux;

import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
@EnableWebFlux
@EnableEurekaClient
public class MicroserviceProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductsApplication.class, args);
	}

}
