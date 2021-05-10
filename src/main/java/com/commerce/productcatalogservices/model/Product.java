package com.commerce.productcatalogservices.model;

public class Product {

    public String productId;
    public String name;
    public int price;
    public String description;

    public Product(){}
    public Product(String productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public Product(String productId, String name, int price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
