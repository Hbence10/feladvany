package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@Tag(name = "Feladvány", description = "Termékeket visszaadó API")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Termékek kilistázása", description = "Az adott kritériumok alapján visszaadja a termékeket.")
    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "filter", defaultValue = "name") String filter, @RequestParam(name = "sort", defaultValue = "ASC") String sort, @RequestParam(name = "onlyValid", defaultValue = "false") String onlyValid) {
        return productService.getProducts(filter, sort, onlyValid.equals("true"));
    }
}
