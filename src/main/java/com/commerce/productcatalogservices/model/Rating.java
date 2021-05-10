package com.commerce.productcatalogservices.model;

public class Rating {

    public String productId;
    public int rating;

    public Rating(){}
    public Rating(String productId, int rating) {
        this.productId = productId;
        this.rating = rating;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
