package com.jeffdev.microserviceproducts.services.interfaces;

import com.jeffdev.commons.entity.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IProductService {
    Flux<Product> getAllProducts();
    Mono<Product> findProduct(Long id);
}
