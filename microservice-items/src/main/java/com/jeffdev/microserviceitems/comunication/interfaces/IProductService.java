package com.jeffdev.microserviceitems.comunication.interfaces;

import com.jeffdev.microserviceitems.models.Item;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;


@Service
public interface IProductService {
    Flux<Item> findAll();
    Mono<Item> findById(Long id, Integer quantity);
}
