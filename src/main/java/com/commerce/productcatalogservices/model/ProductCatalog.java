package com.commerce.productcatalogservices.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalog {

    public int id;
    public String name;
    public String price;
    public String rating;
    public String message;

    public ProductCatalog(String message){
        this.message = message;
    }

}
