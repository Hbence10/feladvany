package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    ArrayList<String> filterTypeList = new ArrayList<>(Arrays.asList("name", "netPrice", "grossPrice"));
    ArrayList<String> sortTypeList = new ArrayList<>(Arrays.asList("ASC", "DESC"));
    private final ProductRepository productRepository;


    public ResponseEntity<Object> getProducts(String filter, String sort, Boolean onlyValid) {
        List<Product> returnList = new ArrayList<Product>();

        if (!sortTypeList.contains(sort)) {
            return ResponseEntity.status(400).body("InvalidSortType");
        } else if (!filterTypeList.contains(filter)) {
            return ResponseEntity.status(400).body("InvalidFilterType");
        } else {
            if (filter.equals("name")) {
                if (sort.equals("ASC")) {
                    returnList = productRepository.findAllOrderByHunNameASC();
                } else {
                    returnList = productRepository.findAllOrderByHunNameASC().reversed();
                }
            } else if (filter.equals("netPrice")) {
                if (sort.equals("ASC")) {
                    returnList = productRepository.findAllOrderByNetPriceASC();
                } else {
                    returnList = productRepository.findAllOrderByNetPriceASC().reversed();
                }
            } else if (filter.equals("grossPrice")) {
                if (sort.equals("ASC")) {
                    returnList = productRepository.findAllOrderByGrossPriceASC();
                } else {
                    returnList = productRepository.findAllOrderByGrossPriceASC().reversed();
                }
            }

            if (onlyValid) {
                return ResponseEntity.ok().body(returnList.stream().filter(product -> !product.getIsIncorrect()).toList());
            }

            return ResponseEntity.ok().body(returnList);
        }
    }
}
