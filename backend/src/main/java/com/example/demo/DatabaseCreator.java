package com.example.demo;

import com.example.demo.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseCreator {

    private final ProductRepository productRepository;

    @PostConstruct
    public void createDatabase() {

    }
}
