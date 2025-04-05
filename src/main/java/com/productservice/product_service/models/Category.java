package com.productservice.product_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Base64;
import java.util.List;

@Setter
@Getter
@Entity
public class Category  extends BaseModel {
    private String name;
    private String description;
    @OneToMany
    private List<Product> featureProducts;

    @OneToMany(mappedBy = "category")
    List<Product> allProducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getFeatureProducts() {
        return featureProducts;
    }

    public void setFeatureProducts(List<Product> featureProducts) {
        this.featureProducts = featureProducts;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }
}
