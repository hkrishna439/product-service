package com.productservice.product_service.services;

import com.productservice.product_service.dtos.FakeStoreCreateProductRequestDto;
import com.productservice.product_service.dtos.FakeStoreGetProductResponseDto;
import com.productservice.product_service.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("fakeStoreProductService")
public class ProductServiceFakeStoreImpl implements ProductService{

    private final RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();
//        fakeStoreCreateProductRequestDto.setCategory(product.getCategory());
        fakeStoreCreateProductRequestDto.setDescription(product.getDescription());
        fakeStoreCreateProductRequestDto.setImage(product.getImageUrl());
        fakeStoreCreateProductRequestDto.setPrice(product.getPrice());
        fakeStoreCreateProductRequestDto.setTitle(product.getTitle());

        FakeStoreGetProductResponseDto fakeStoreCreateProductResponseDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreCreateProductRequestDto,
                FakeStoreGetProductResponseDto.class

        );

        Product product1 = new Product();
//        product1.setCategory(fakeStoreCreateProductResponseDto.getCategory());
        product1.setImageUrl(fakeStoreCreateProductResponseDto.getImage());
        product1.setPrice(fakeStoreCreateProductResponseDto.getPrice());
        product1.setTitle(fakeStoreCreateProductRequestDto.getTitle());
        product1.setDescription(fakeStoreCreateProductRequestDto.getDescription());
//        product1.setId(fakeStoreCreateProductResponseDto.getId());

        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                    FakeStoreGetProductResponseDto[].class
        );

        List<FakeStoreGetProductResponseDto> responseList = Stream.of(response).toList();

        List<Product> products = new ArrayList<>();

        for(FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto: responseList){
            products.add(fakeStoreGetProductResponseDto.toProduct());
        }

        return products;
    }
}
