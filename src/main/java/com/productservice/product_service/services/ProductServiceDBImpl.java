package com.productservice.product_service.services;

import com.productservice.product_service.models.Category;
import com.productservice.product_service.models.Product;
import com.productservice.product_service.repositories.CategoryRepository;
import com.productservice.product_service.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findByName(categoryName);
        Category tobePutInProduct = null;

        if(category.isEmpty()){
            Category category1 = new Category();
            category1.setName(categoryName);
            categoryRepository.save(category1);
        } else {
            tobePutInProduct = category.get();
        }

        product.setCategory(tobePutInProduct);

        Product product1 = productRepository.save(product);

        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
