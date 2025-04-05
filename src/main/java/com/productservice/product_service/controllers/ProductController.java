package com.productservice.product_service.controllers;

import com.productservice.product_service.dtos.*;
import com.productservice.product_service.models.Product;
import com.productservice.product_service.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("dbProductService") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.createProduct(createProductRequestDto.toProduct());

        return CreateProductDto.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts(){
        List<Product> products = productService.getAllProducts();

        GetAllProductsResponseDto getProductResponseDtos = new GetAllProductsResponseDto();

        List<GetProductDto> getProductDtos = new ArrayList<>();

        for(Product product: products){
            getProductDtos.add(GetProductDto.from(product));
        }

        getProductResponseDtos.setProducts(getProductDtos);

        return getProductResponseDtos;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id){
        return "here is the product " + id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }

    @PatchMapping
    public void updateProduct(){

    }

    @PutMapping
    public void replaceProduct(){

    }
    @RequestMapping(name="Krishna", value = "/")
    public String krishnaAPI(){
        return "Magic";
    }
}
