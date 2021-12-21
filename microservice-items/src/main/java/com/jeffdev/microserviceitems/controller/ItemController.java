package com.jeffdev.microserviceitems.controller;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import com.jeffdev.commons.entity.Product;
import com.jeffdev.microserviceitems.comunication.interfaces.IProductService;
import com.jeffdev.microserviceitems.models.Item;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
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
@RefreshScope
public class ItemController {

    @Autowired
    IProductService iProductService;

    @Autowired
    ReactiveCircuitBreakerFactory cbFactory;

    @Value("${configuration.texto}")
    String textConfig;

    @Autowired
    Environment environment;

    private final Logger logger = LoggerFactory.getLogger(ItemController.class);


    @GetMapping("/all")
    public Flux<Item> getAllProducts(){
        return iProductService.findAll();
    }

    @GetMapping("/configs")
    public Flux<HashMap<String, Object>> getAllConfigs(@Value("${server.port}") String port){
        HashMap<String,Object> json = new HashMap<>();
        json.put("textConfig",textConfig);
        json.put("port",port);
        if (environment.getActiveProfiles().length > 0 && environment.getActiveProfiles()[0].equals("dev")) {
            json.put("name", environment.getProperty("configuration.developer.name"));
        }
        return Flux.just(json);
    }

    @GetMapping("/getItem")
    public Mono<Item> getItemByIdAndQuantity(@RequestParam Long id, @RequestParam Integer quantity){
    	return cbFactory.create("items").run(iProductService.findById(id,quantity), throwable -> Mono.just(this.metodoAlternativo(id, quantity, throwable)));
    }

    @GetMapping("/getItem2")
    @TimeLimiter(name = "items", fallbackMethod = "metodoAlternativo2")
    public CompletableFuture<Item> getItemByIdAndQuantity2(@RequestParam Long id, @RequestParam Integer quantity){
        return CompletableFuture.supplyAsync(()->iProductService.findById(id,quantity).block());
    }
    
    public Item metodoAlternativo(Long id, Integer cantidad, Throwable e) {
    	logger.info(e.getMessage());
        Product product  = new Product();
        product.setProductCreateDate(null);
        product.setProductId(1L);
        product.setProductName("Camara sony");
        product.setProductPrice(1000.00);
    	Item item = new Item(product,1);
    	return item;
    }

    public CompletableFuture<Item> metodoAlternativo2(Long id, Integer cantidad, Throwable e) {
        logger.info(e.getMessage());
        Product product  = new Product();
        product.setProductCreateDate(null);
        product.setProductId(1L);
        product.setProductName("Camara sony");
        product.setProductPrice(1000.00);
        Item item = new Item(product,1);
        return CompletableFuture.supplyAsync(()->item);
    }
}
