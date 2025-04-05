package com.productservice.product_service.dtos;

import com.productservice.product_service.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static CreateProductDto fromProduct(Product product){
        CreateProductDto createProductDto = new CreateProductDto();

        createProductDto.setId(product.getId());
        createProductDto.setDescription(product.getDescription());
        createProductDto.setPrice(product.getPrice());
        createProductDto.setTitle(product.getTitle());
        createProductDto.setImageUrl(product.getImageUrl());

        return createProductDto;
    }
}
