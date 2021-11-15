package com.jeffdev.microservicegatewayserver.filters.factory;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class EjemploGatewayFilterFactory extends AbstractGatewayFilterFactory<Configuration> {
	
	private final Logger logger = LoggerFactory.getLogger(EjemploGatewayFilterFactory.class);

	public EjemploGatewayFilterFactory() {
		super(Configuration.class);
	}

	@Override
	public GatewayFilter apply(Configuration config) {
		return (exchange,chain) ->{
			logger.info("Ejecutando pre filter factory: " + config.getMensaje());
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				Optional.ofNullable(config.getCookieValor()).ifPresent(cookie -> {
					exchange.getResponse().addCookie(ResponseCookie.from(config.getCookieNombre(), cookie).build());
				});
				logger.info("Ejecutando post filter factory: " + config.getMensaje());
			}));
		};
	}

}
