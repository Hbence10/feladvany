package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Product.findAllOrderByHunNameASC", query = "select p from Product p order by p.hunProductName ASC", resultClass = Product.class),
        @NamedQuery(name = "Product.findAllOrderByNetPriceASC", query = "select p from Product p order by p.netPriceHuf ASC", resultClass = Product.class),
        @NamedQuery(name = "Product.findAllOrderByGrossPriceASC", query = "select p from Product p order by p.grossPriceHuf ASC", resultClass = Product.class),
})
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
    private Boolean isIncorrect;

    public void checkIfCorrect() {
        this.isIncorrect = this.sku == null || this.hunProductName == null || this.englishProductName == null || this.grossPriceHuf == null || this.netPriceHuf == null || this.currency == null || this.vatRate == null || this.quantityAvailable == null || this.stockQuantity == null || this.brand == null || this.ean == null;
    }
}
