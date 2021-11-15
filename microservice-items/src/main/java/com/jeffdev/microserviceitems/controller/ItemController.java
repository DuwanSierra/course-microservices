package com.jeffdev.microserviceitems.controller;

import java.util.Date;

import com.jeffdev.microserviceitems.comunication.interfaces.IProductService;
import com.jeffdev.microserviceitems.models.Item;
import com.jeffdev.microserviceitems.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    IProductService iProductService;

    @Autowired
    ReactiveCircuitBreakerFactory cbFactory;
    
    
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);


    @GetMapping("/all")
    public Flux<Item> getAllProducts(){
        return iProductService.findAll();
    }

    @GetMapping("/getItem")
    public Mono<Item> getItemByIdAndQuantity(@RequestParam Long id, @RequestParam Integer quantity){
    	return cbFactory.create("items").run(iProductService.findById(id,quantity), throwable -> Mono.just(this.metodoAlternativo(id, quantity, throwable)));
    }
    
    public Item metodoAlternativo(Long id, Integer cantidad, Throwable e) {
    	logger.info(e.getMessage());
        Product product  = new Product();
        product.setProductCreateDate(new Date());
        product.setProductId(1L);
        product.setProductName("Camara sony");
        product.setProductPrice(1000.00);
    	Item item = new Item(product,1);
    	return item;
    }
}
