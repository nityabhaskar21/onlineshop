package com.example.onlineshop.dtos;

import com.example.onlineshop.models.Attribute;
import com.example.onlineshop.models.Inventory;
import com.example.onlineshop.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private String description;
    private Inventory inventory;
    private List<Attribute> attributes;

    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setName(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setInventory(product.getInventory());
        responseDto.setAttributes(product.getAttributes());

        return responseDto;
    }
}
