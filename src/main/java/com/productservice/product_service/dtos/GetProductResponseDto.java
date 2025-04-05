package com.productservice.product_service.dtos;

import com.productservice.product_service.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private GetProductDto product;

    public GetProductDto getProduct() {
        return product;
    }

    public void setProduct(GetProductDto product) {
        this.product = product;
    }
}
