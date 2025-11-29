package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres termék lista lekérdezés.", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", description = "Nem megfelelő filter vagy sort tipus.", useReturnTypeSchema = false)
    })
    @Parameters({
            @Parameter(name = "filter", allowEmptyValue = true, description = "Az adott rendezés tipusa. 3 fajta lehet csak: name, netPrice vagy grossPrice."),
            @Parameter(name = "sort", allowEmptyValue = true, description = "Az adott rendezés sorrendjét ábrázolja. 2 fajta lehet csak: ASC (növekvő) vagy DESC (csökkenő)."),
            @Parameter(name = "onlyValid", allowEmptyValue = true, description = "Azt adja vissza, hogy érvényes vagy nem érvényes termékek jönnek vissza. 2 fajta lehet csak: true (csak érvényes) vagy false (nem csak érvényes)."),
    })
    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "filter", defaultValue = "name") String filter, @RequestParam(name = "sort", defaultValue = "ASC") String sort, @RequestParam(name = "onlyValid", defaultValue = "false") String onlyValid) {
        return productService.getProducts(filter, sort, onlyValid.equals("true"));
    }
}
