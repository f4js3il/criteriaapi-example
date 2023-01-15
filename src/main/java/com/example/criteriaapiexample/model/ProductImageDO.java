package com.example.criteriaapiexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductImageDO {
//https://www.appsdeveloperblog.com/specification-predicate-advance-search-and-filtering-in-jpa/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "image_name")
    private String image;

}
