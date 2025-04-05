package com.productservice.product_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductsResponseDto {
    private List<GetProductDto> products;

    public List<GetProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<GetProductDto> products) {
        this.products = products;
    }
}
