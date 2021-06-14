package com.commerce.productcatalogservices.rest;

import com.commerce.productcatalogservices.model.Product;
import com.commerce.productcatalogservices.model.ProductCatalog;
import com.commerce.productcatalogservices.model.Rating;
import com.commerce.productcatalogservices.model.UserReview;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping("/{prodId}")
    //@HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public ProductCatalog getProductCatalog(@PathVariable("prodId")String prodId){

        Product product = restTemplate.getForObject("http://product-info-services/products/getProduct/"+prodId, Product.class);

        Rating ratings = restTemplate.getForObject("http://product-review-service/reviews-data/findRating/"+ product.getId(),Rating.class);

        ProductCatalog productCatalog = null;
        if(ratings !=null){
                productCatalog = new ProductCatalog(product.getId(),product.getName(),product.getPrice(), ratings.getRating(),"ratings found");
            }else{
            productCatalog = new ProductCatalog(product.getId(),product.getName(),product.getPrice(),"","no ratings was found on given prod id");
        }
        return productCatalog;

    }



    @SuppressWarnings("unused")
    public List<String> getFallbackCatalog(@PathVariable("userId")String userId){
        return Arrays.asList(new String("No Product Itrmes are found"));
    }

}
