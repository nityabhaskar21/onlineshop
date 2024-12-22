package com.example.onlineshop.dtos;

import com.example.onlineshop.models.Attribute;
import com.example.onlineshop.models.Inventory;
import com.example.onlineshop.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductRequestDto {
    private String name;
    private String brand;
    private Double price;
    private String description;
    private Inventory inventory;
    private List<Attribute> attributes;

    public Product toProduct() {
        Product product = new Product();
        product.setName(this.name);
        product.setBrand(this.brand);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setInventory(this.inventory);
        product.setAttributes(this.attributes);
        return product;
    }
}
