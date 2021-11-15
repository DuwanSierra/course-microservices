package com.jeffdev.microserviceitems.models;


import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private Long productId;

    private String productName;

    private Double productPrice;

    private Date productCreateDate;
}
