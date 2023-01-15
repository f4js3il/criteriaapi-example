package com.example.criteriaapiexample.service;

import com.example.criteriaapiexample.payload.Product;
import com.example.criteriaapiexample.repository.ProductRepository;
//import static com.example.criteriaapiexample.specification.ProductSpecification.*;
//import static org.springframework.data.jpa.domain.Specification.*;
import com.example.criteriaapiexample.specification.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll().stream().map(Product:: new).collect(Collectors.toList());
    }

    public List<Product> getProductsByBrandName(String brandName){
        return productRepository.findAll(Specification.where(ProductSpecification.hasBrandName(brandName))).stream().map(Product:: new).collect(Collectors.toList());
       //After doing Static import
        // return productRepository.findAll(where(hasBrandName(brandName))).stream().map(Product:: new).collect(Collectors.toList());
    }

    public List<Product> getProductsByBrandNameAndPrice(String brandName, Double originalPrice){
        return productRepository.findAll(Specification.where(ProductSpecification.hasBrandName(brandName))
                .and(ProductSpecification.hasOriginalPrice(originalPrice)).and(ProductSpecification.getProductWithImages("image1.jpeg"))).stream().map(Product:: new).collect(Collectors.toList());
    }

    public List<Product> getProductsByDescription(String description){
        return productRepository.findAll(Specification.where(ProductSpecification.containsDescription(description))).stream().map(Product:: new).collect(Collectors.toList());
    }

}
