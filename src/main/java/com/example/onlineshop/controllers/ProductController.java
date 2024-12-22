package com.example.onlineshop.controllers;

import com.example.onlineshop.dtos.CreateProductRequestDto;
import com.example.onlineshop.dtos.CreateProductResponseDto;
import com.example.onlineshop.dtos.GetAllProductsResponseDto;
import com.example.onlineshop.dtos.GetProductDto;
import com.example.onlineshop.models.Product;
import com.example.onlineshop.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final RestTemplate restTemplate;
    private final ProductService productService;

    public ProductController(ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("")
    public ResponseEntity<CreateProductResponseDto> createProduct(@RequestHeader("Authorization") String token,
                                                  @RequestBody CreateProductRequestDto createProductRequestDto) {
        boolean isAuthenticated = Boolean.TRUE.equals(restTemplate.getForObject(
                "http://userService/auth/validate?token=" + token,
                Boolean.class
        ));

        if (!isAuthenticated) {
            return null;
        }

        Product product = productService.createProduct(
                createProductRequestDto.toProduct()
        );

        CreateProductResponseDto createProductResponse =  CreateProductResponseDto.fromProduct(
                product
        );
        return new ResponseEntity<CreateProductResponseDto>(createProductResponse,HttpStatus.CREATED);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts() {
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();

        List<GetProductDto> getProductResponseDtos = new ArrayList<>();

        for (Product product: products) {
            getProductResponseDtos.add(GetProductDto.from(product));
        }

        response.setProducts(getProductResponseDtos);

        return response;
    }
}
