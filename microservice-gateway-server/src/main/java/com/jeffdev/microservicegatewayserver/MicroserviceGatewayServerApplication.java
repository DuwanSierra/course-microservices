package com.jeffdev.microservicegatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayServerApplication.class, args);
	}

}
