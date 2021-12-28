package com.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.model.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Long>{

}
