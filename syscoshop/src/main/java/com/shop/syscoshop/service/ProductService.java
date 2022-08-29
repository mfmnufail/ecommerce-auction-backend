package com.shop.syscoshop.service;

import com.shop.syscoshop.entity.Product;
import com.shop.syscoshop.payload.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    List<Product> getAllProducts();
    ProductDto getProductById(UUID id);
    ProductDto updateProduct(ProductDto productDto);
    ProductDto deleteProduct(UUID id);

}
