package com.jeffdev.microserviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroserviceconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceconfigApplication.class, args);
	}

}
