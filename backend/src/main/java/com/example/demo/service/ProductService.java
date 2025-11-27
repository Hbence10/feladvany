package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    ArrayList<String> filterTypeList = new ArrayList<>(Arrays.asList("name", "netPrice", "grossPrice"));
    ArrayList<String> sortTypeList = new ArrayList<>(Arrays.asList("ASC", "DESC"));
    private final ProductRepository productRepository;


    public ResponseEntity<Object> getProducts(String filter, String sort, Boolean onlyValid) {
        if (!sortTypeList.contains(sort)) {
            return ResponseEntity.status(400).body("InvalidSortType");
        } else if (!filterTypeList.contains(filter)) {
            return ResponseEntity.status(400).body("InvalidFilterType");
        } else {
            if (filter.equals("name")) {
                if (sort.equals("ASC")) {
                    return ResponseEntity.ok().body(productRepository.findAllOrderByHunNameASC());
                } else {
                    return ResponseEntity.ok().body(productRepository.findAllOrderByHunNameDESC());
                }
            } else if (filter.equals("netPrice")) {
                if (sort.equals("ASC")) {
                    return ResponseEntity.ok().body(productRepository.findAllOrderByNetPriceASC());
                } else {
                    return ResponseEntity.ok().body(productRepository.findAllOrderByNetPriceDESC());
                }
            } else if (filter.equals("grossPrice")) {
                if (sort.equals("ASC")) {
                    return ResponseEntity.ok().body(productRepository.findAllOrderByGrossPriceASC());
                } else {
                    return ResponseEntity.ok().body(productRepository.findAllOrderByGrossPriceDESC());
                }
            }

            return null;
        }
    }
}
