package com.jeffdev.microserviceitems.models;

import com.jeffdev.commons.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Product product;
    Integer quantity;

    public Double getTotal(){
        return product.getProductPrice() * quantity;
    }
}
