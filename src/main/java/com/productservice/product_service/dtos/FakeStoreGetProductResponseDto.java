package com.productservice.product_service.dtos;

import com.productservice.product_service.models.Category;
import com.productservice.product_service.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product toProduct(){
        Product product = new Product();

        Category category1 = new Category();
        product.setCategory(category1);
        product.setImageUrl(this.getImage());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setId(this.getId());

        return product;
    }

}
