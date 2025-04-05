package com.productservice.product_service.services;

import com.productservice.product_service.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
}
