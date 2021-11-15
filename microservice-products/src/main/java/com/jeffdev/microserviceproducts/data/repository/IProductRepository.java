package com.jeffdev.microserviceproducts.data.repository;

import com.jeffdev.microserviceproducts.data.entity.Product;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveSortingRepository<Product,Long> {
}
