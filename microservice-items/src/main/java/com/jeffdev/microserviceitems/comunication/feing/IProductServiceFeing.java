package com.jeffdev.microserviceitems.comunication.feing;

import com.jeffdev.commons.entity.Product;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@ReactiveFeignClient(name="microservice-products", url="${microservice-products.url}")
public interface IProductServiceFeing {
	
    @GetMapping("/product/all")
    public Flux<Product> getAll();

    @GetMapping("/product/{id}")
    public Mono<Product> findProduct(@PathVariable Long id);
}
