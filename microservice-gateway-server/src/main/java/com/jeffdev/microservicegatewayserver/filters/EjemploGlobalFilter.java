package com.jeffdev.microservicegatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;



import reactor.core.publisher.Mono;

@Component
public class EjemploGlobalFilter implements GlobalFilter, Ordered{
	
	private final Logger logger = LoggerFactory.getLogger(EjemploGlobalFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Ejecutando pre filter");
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			logger.info("Ejecutando post filter");
			exchange.getResponse().getCookies().add("COLOR", ResponseCookie.from("COLOR", "ROJO").build());
		}));
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
