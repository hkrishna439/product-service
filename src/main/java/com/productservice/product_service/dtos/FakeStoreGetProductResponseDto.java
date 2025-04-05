package com.productservice.product_service.dtos;

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

    public Product toProduct(){
        Product product = new Product();

        product.setCategoryName(this.getCategory());
        product.setImageUrl(this.getImage());
        product.setPrice(this.getPrice());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setId(this.getId());

        return product;
    }

}
