package com.productservice.product_service.dtos;

import com.productservice.product_service.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static GetProductDto from(Product product){
        GetProductDto getProductDto = new GetProductDto();

        getProductDto.setId(product.getId());
        getProductDto.setTitle(product.getTitle());
        getProductDto.setDescription(product.getDescription());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setImageUrl(product.getImageUrl());

        return getProductDto;


    }
}
