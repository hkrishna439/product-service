package com.productservice.product_service.dtos;

import com.productservice.product_service.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private CreateProductDto createProductDto;

    public CreateProductDto getCreateProductDto() {
        return createProductDto;
    }

    public void setCreateProductDto(CreateProductDto createProductDto) {
        this.createProductDto = createProductDto;
    }
}
