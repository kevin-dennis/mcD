package com.mcdonald.mcdonald.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.mcdonald.Models.ProductModel;

import com.mcdonald.mcdonald.Repositories.ProductRepository;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String addProduct(ProductModel product) {
        productRepository.save(product);
        return "Product added";
    }

    public List<ProductModel> viewMenu(){
       return  productRepository.findAll();
    }
}
