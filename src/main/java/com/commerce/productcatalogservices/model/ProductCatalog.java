package com.commerce.productcatalogservices.model;

public class ProductCatalog {
    public String name;
    public String description;
    public int rating;

    public ProductCatalog(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
