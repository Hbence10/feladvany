package com.example.demo.service;

import com.example.demo.model.Product;
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
    ArrayList<String> filterTypeList = new ArrayList<>(Arrays.asList());
    ArrayList<String> sortTypeList = new ArrayList<>(Arrays.asList());

    public ResponseEntity<Product> getProducts(String filter, String sort, String onlyValid){
        return null;
    }
}
