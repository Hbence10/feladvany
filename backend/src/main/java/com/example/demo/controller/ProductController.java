package com.example.demo.controller;

import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<Object> getProducts(@RequestParam(value = "filter", defaultValue = "text") String filter, @RequestParam(value = "sort", defaultValue = "ASC") String sort, @RequestParam(value = "onlyValid", defaultValue = "false") String onlyValid) {
        return productService.getProducts(filter, sort, onlyValid.equals("true"));
    }
}
