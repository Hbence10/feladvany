package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {

    private Integer id;
    private String productName;
    private Integer grossPriceHuf;
    private Integer netPriceHuf;
    private String currency;
    private Double vatRate;
    private Integer quantityAvailable;
    private Integer stockQuantity;
    private Integer brand;
    private Integer ean;
    private LocalDateTime updatedAt;
}
