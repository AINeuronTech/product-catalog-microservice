package com.commerce.productcatalogservices.rest;

import com.commerce.productcatalogservices.model.Product;
import com.commerce.productcatalogservices.model.ProductCatalog;
import com.commerce.productcatalogservices.model.UserReview;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogResources {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public List<ProductCatalog> getProductCatalog(@PathVariable("userId")String userId){

        UserReview userRating = restTemplate.getForObject("http://product-review-service/reviews-data/user/"+userId, UserReview.class);

        return userRating.getRatings().stream().map(rating -> {
            Product product = restTemplate.getForObject("http://product-info-services/products/getProduct"+ rating.getProductId(),Product.class);
            return new ProductCatalog(product.getProdName(), product.getProdPrice(), rating.getRating());
        }).collect(Collectors.toList());

    }


    @SuppressWarnings("unused")
    public List<ProductCatalog> getFallbackCatalog(@PathVariable("userId")String userId){
        return Arrays.asList(new ProductCatalog("No Product Itrmes are found","",0));
    }

}
