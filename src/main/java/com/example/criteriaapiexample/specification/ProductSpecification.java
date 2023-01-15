package com.example.criteriaapiexample.specification;

import com.example.criteriaapiexample.model.ProductDO;
import com.example.criteriaapiexample.model.ProductDO_;
import com.example.criteriaapiexample.model.ProductImageDO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;

@Component
public class ProductSpecification {

    public static Specification<ProductDO> hasBrandName(String brandName){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductDO_.BRAND_NAME),brandName);
    }

    public static Specification<ProductDO> hasOriginalPrice(Double originalPrice){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductDO_.ORIGINAL_PRICE),originalPrice);
    }

    public static Specification<ProductDO> containsDescription(String description){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),"%"+description+"%");
    }

    public static Specification<ProductDO> getProductWithImages(String imageName){
        return ((root, query, criteriaBuilder) -> {
            Join< ProductImageDO,ProductDO> joins = root.join("images");
            return criteriaBuilder.equal(joins.get("image"),imageName);
        });
    }
}
