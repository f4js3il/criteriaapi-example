package com.example.criteriaapiexample.controller;

import com.example.criteriaapiexample.payload.Product;
import com.example.criteriaapiexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/products/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value="all")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value="{brandName}")
    public ResponseEntity<List<Product>> getProductsByBrandName(@PathVariable String brandName){
        return ResponseEntity.ok(productService.getProductsByBrandName(brandName));
    }

    @GetMapping(value="{brandName}/price/{price}")
    public ResponseEntity<List<Product>> getProductsByBrandNameAndPrice(@PathVariable String brandName,@PathVariable Double price){
        return ResponseEntity.ok(productService.getProductsByBrandNameAndPrice(brandName,price));
    }

    @GetMapping(value="description/{description}")
    public ResponseEntity<List<Product>> getProductsByDescription(@PathVariable String description){
        return ResponseEntity.ok(productService.getProductsByDescription(description));
    }
}
