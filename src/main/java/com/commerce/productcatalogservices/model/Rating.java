package com.commerce.productcatalogservices.model;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    public int id;
    public String rating;

    public Rating(String rating){
        this.rating = rating;
    }

}
