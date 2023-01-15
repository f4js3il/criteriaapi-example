package com.example.criteriaapiexample.payload;

import com.example.criteriaapiexample.model.ProductDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Long id;
    private String brand_name;
    private String description;
    private String name;
    private Double offer_price;
    private LocalDateTime offer_valid_until;
    private Double original_price;

    public Product(ProductDO product) {
        BeanUtils.copyProperties(product, this);
    }
}
