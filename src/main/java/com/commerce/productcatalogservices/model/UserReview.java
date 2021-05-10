package com.commerce.productcatalogservices.model;

import java.util.List;

public class UserReview {
    public String userId;
    public List<Rating> ratings;
    public UserReview(){}
    public UserReview(String userId, List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
