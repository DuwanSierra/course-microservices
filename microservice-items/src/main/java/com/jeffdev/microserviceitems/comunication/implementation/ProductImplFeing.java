package com.jeffdev.microserviceitems.comunication.implementation;

import com.jeffdev.microserviceitems.comunication.feing.IProductServiceFeing;
import com.jeffdev.microserviceitems.comunication.interfaces.IProductService;
import com.jeffdev.microserviceitems.models.Item;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class ProductImplFeing implements IProductService {

    @Autowired
    IProductServiceFeing iProductServiceFeing;

	@Override
	public Flux<Item> findAll() {
		Flux<Item> items = iProductServiceFeing.getAll().flatMap(product->Mono.just(new Item(product,0)));
		return items;
	}

	@Override
	public Mono<Item> findById(Long id, Integer quantity) {
		return iProductServiceFeing.findProduct(id).map(product -> { 
			Item item = new Item(product,quantity);
			return item;
		});
	}

    
}
