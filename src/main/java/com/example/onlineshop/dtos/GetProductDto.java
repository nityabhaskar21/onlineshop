package com.example.onlineshop.dtos;

import com.example.onlineshop.models.Attribute;
import com.example.onlineshop.models.Inventory;
import com.example.onlineshop.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private String description;
    private Inventory inventory;
    private List<Attribute> attributes;

    public static GetProductDto from(Product product) {
        GetProductDto getProductResponseDto = new GetProductDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setName(product.getName());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setBrand(product.getBrand());
        getProductResponseDto.setInventory(product.getInventory());
        getProductResponseDto.setAttributes(product.getAttributes());

        return getProductResponseDto;
    }
}
