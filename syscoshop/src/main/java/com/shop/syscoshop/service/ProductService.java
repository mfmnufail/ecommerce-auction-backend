package com.shop.syscoshop.service;

import com.shop.syscoshop.entity.Product;
import com.shop.syscoshop.payload.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    List<Product> getAllProducts();
    ProductDto getProductById(long id);
    ProductDto updateProduct(ProductDto productDto,long id);
    void deleteProduct(long id);

}
