package com.example.demo.service;

import com.example.demo.model.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    public ResponseEntity<Product> getProducts(String filter, String sort, String onlyValid){
        return null;
    }
}
