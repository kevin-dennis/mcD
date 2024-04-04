package com.mcdonald.mcdonald.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcdonald.mcdonald.Models.ProductModel;


public interface ProductRepository extends JpaRepository<ProductModel,UUID>{
    ProductModel findByName(String name);
}
