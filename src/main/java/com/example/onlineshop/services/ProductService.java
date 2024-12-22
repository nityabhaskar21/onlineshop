package com.example.onlineshop.services;

import com.example.onlineshop.exceptions.ProductNotFoundException;
import com.example.onlineshop.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException;
}
