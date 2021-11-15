package com.jeffdev.microserviceproducts.controllers;

import java.util.concurrent.TimeUnit;

import com.jeffdev.microserviceproducts.data.entity.Product;
import com.jeffdev.microserviceproducts.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

    private IProductService iProductService;

    public ProductController(@Autowired IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("/all")
    public Flux<Product> getAll() {
        return this.iProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> findProduct(@PathVariable Long id) throws InterruptedException {
        if (id.equals(10L)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found");

        }
        if (id.equals(7L)) {
            TimeUnit.SECONDS.sleep(5L);
        }
        return this.iProductService.findProduct(id);
    }

}
