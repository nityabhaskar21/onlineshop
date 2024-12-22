package com.example.onlineshop.models;

import com.example.onlineshop.enums.Currency;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Price extends BaseModel {
    private Long amount;
    private Currency currency;
}
