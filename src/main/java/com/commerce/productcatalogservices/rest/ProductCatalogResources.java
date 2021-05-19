package com.commerce.productcatalogservices.rest;

import com.commerce.productcatalogservices.model.Product;
import com.commerce.productcatalogservices.model.ProductCatalog;
import com.commerce.productcatalogservices.model.UserReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogResources {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<ProductCatalog> getProductCatalog(@PathVariable("userId")String userId){

        UserReview userRating = restTemplate.getForObject("http://product-review-service/reviews-data/user/"+userId, UserReview.class);

        return userRating.getRatings().stream().map(rating -> {
            Product product = restTemplate.getForObject("http://product-info-services/products/"+ rating.getProductId(),Product.class);
            return new ProductCatalog(product.getName(), product.getDescription(), rating.getRating());
        }).collect(Collectors.toList());

    }
}
