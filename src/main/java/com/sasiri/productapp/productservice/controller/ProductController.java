package com.sasiri.productapp.productservice.controller;

import com.sasiri.productapp.productservice.dto.ProductRequest;
import com.sasiri.productapp.productservice.dto.ProductResponse;
import com.sasiri.productapp.productservice.model.Product;
import com.sasiri.productapp.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
       return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
