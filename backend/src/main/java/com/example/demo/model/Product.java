package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sku;
    private String hunProductName;
    private String englishProductName;
    private Integer grossPriceHuf;
    private Integer netPriceHuf;
    private String currency;
    private Double vatRate;
    private Integer quantityAvailable;
    private Integer stockQuantity;
    private String brand; //
    private String ean;
    private LocalDateTime updatedAt; //
}
