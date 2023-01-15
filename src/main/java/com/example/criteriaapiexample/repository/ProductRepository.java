package com.example.criteriaapiexample.repository;

import com.example.criteriaapiexample.model.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<ProductDO, Integer>, JpaSpecificationExecutor<ProductDO> {
}
