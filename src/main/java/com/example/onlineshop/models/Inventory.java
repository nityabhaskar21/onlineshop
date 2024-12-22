package com.example.onlineshop.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inventory extends BaseModel {
    private Long total;
    private Long available;
    private Long reserved;
}
