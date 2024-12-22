package com.example.onlineshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    @NotNull
    @Size(min = 3, max = 30, message = "Product name size should be between 3-30")
    private String name;
    private String brand;
    @NotNull
    @DecimalMin(value = "0.00")
    private Double price;
    private String description;
    @OneToOne
    private Inventory inventory;
    @OneToMany(mappedBy = "product")
    private List<Attribute> attributes;
}
