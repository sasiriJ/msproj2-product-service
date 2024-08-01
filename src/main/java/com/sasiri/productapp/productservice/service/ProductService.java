package com.sasiri.productapp.productservice.service;

import com.sasiri.productapp.productservice.dto.ProductRequest;
import com.sasiri.productapp.productservice.dto.ProductResponse;
import com.sasiri.productapp.productservice.model.Product;
import com.sasiri.productapp.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("product Created successfully");
        return new ProductResponse(product.getId(),product.getName(),
                product.getDescription(), productRequest.skuCode(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
       return productRepository.findAll().stream().map((product ->
               new ProductResponse(product.getId(), product.getName(),
                       product.getDescription(), product.getSkuCode(), product.getPrice()))).toList();
    }
}
