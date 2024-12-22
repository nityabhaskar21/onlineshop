package com.example.onlineshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Attribute extends BaseModel{
    private String name;
    private String valueAmount;
    @ManyToOne
    private Product product;
}
