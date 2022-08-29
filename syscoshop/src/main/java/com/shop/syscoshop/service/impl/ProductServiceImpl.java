package com.shop.syscoshop.service.impl;

import com.shop.syscoshop.entity.Product;
import com.shop.syscoshop.payload.ProductDto;
import com.shop.syscoshop.repository.ProductRepository;
import com.shop.syscoshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        Product newProduct = productRepository.save(product);

        ProductDto responseProduct = new ProductDto();
        responseProduct.setProductName(newProduct.getProductName());
        responseProduct.setPrice(newProduct.getPrice());
        responseProduct.setDescription(newProduct.getDescription());

        return responseProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto getProductById(UUID id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProduct(UUID id) {
        return null;
    }
}
