package com.jeffdev.microserviceitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.reactive.config.EnableWebFlux;

import reactivefeign.spring.config.EnableReactiveFeignClients;

@EnableAutoConfiguration(exclude = {R2dbcAutoConfiguration.class})
@EnableReactiveFeignClients
@EnableWebFlux
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceItemsApplication.class, args);
	}

}
