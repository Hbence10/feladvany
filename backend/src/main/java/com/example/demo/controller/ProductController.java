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
    public ResponseEntity<Object> getProducts(@RequestParam(name = "filter", defaultValue = "name") String filter, @RequestParam(name = "sort", defaultValue = "ASC") String sort, @RequestParam(name = "onlyValid", defaultValue = "false") String onlyValid) {
        return productService.getProducts(filter, sort, onlyValid.equals("true"));
    }
}
