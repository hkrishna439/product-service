package com.productservice.product_service.services;

import com.productservice.product_service.models.Product;
import com.productservice.product_service.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
