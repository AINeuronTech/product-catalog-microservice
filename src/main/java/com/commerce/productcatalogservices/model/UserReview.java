package com.commerce.productcatalogservices.model;

import java.util.List;

import lombok.*;
import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserReview")
public class UserReview {

    public String userName;
    public int prodId;
    public List<String> review;

    public UserReview(List<String> review){
        this.review = review;
    }

}
