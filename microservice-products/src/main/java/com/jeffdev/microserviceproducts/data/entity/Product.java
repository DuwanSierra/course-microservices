package com.jeffdev.microserviceproducts.data.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.sql.Date;


@Table(value = "R_PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(value = "PRODUCT_ID")
    private Long productId;

    @Column(value = "PRODUCT_NAME")
    private String productName;

    @Column(value = "PRODUCT_PRICE")
    private Double productPrice;

    @Column(value = "PRODUCT_CREATE_DATE")
    private Date productCreateDate;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Date getProductCreateDate() {
        return productCreateDate;
    }

    public void setProductCreateDate(Date productCreateDate) {
        this.productCreateDate = productCreateDate;
    }
}
