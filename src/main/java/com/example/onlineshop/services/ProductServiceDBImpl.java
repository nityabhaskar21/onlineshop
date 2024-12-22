package com.example.onlineshop.services;

import com.example.onlineshop.exceptions.ProductNotFoundException;
import com.example.onlineshop.models.Product;
import com.example.onlineshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDBImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceDBImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @Override
    public Product partialUpdateProduct(Long productId,
                                        Product product) throws ProductNotFoundException {

        Optional<Product> productToUpdateOptional = productRepository.findById(productId);

        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productToUpdate = productToUpdateOptional.get();

        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }

        if (product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }

        if (product.getName() != null) {
            productToUpdate.setName(product.getName());
        }

        if (product.getInventory() != null) {
            productToUpdate.setInventory(product.getInventory());
        }

        return productRepository.save(productToUpdate);
    }
}
