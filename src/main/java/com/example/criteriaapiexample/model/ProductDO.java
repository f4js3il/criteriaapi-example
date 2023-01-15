package com.example.criteriaapiexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
public class ProductDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;
    private String brand_name;
    private String description;
    private String name;
    private Double offer_price;
    private LocalDateTime offer_valid_until;
    private Double original_price;

    @OneToMany(cascade = CascadeType.ALL)
    public List<ProductImageDO> images;
}
