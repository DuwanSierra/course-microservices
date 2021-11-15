package com.jeffdev.microserviceproducts.services.implementation;

import com.jeffdev.microserviceproducts.data.entity.Product;
import com.jeffdev.microserviceproducts.data.repository.IProductRepository;
import com.jeffdev.microserviceproducts.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Flux<Product> getAllProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Mono<Product> findProduct(Long id) {
        return iProductRepository.findById(id);
    }
}
