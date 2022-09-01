package com.shop.syscoshop.service.impl;

import com.shop.syscoshop.entity.Product;
import com.shop.syscoshop.exception.ResourceNotFoundException;
import com.shop.syscoshop.payload.ProductDto;
import com.shop.syscoshop.repository.ProductRepository;
import com.shop.syscoshop.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        product.setCategory(productDto.getCategory());

        Product newProduct = productRepository.save(product);

        ProductDto responseProduct = new ProductDto();
        responseProduct.setId(newProduct.getId());
        responseProduct.setProductName(newProduct.getProductName());
        responseProduct.setPrice(newProduct.getPrice());
        responseProduct.setDescription(newProduct.getDescription());
        responseProduct.setCategory(newProduct.getCategory());

        return responseProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto getProductById(UUID id) {
//        Product product =  productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
//        ProductDto responseProduct = new ProductDto();
//        responseProduct.setId(product.getId());
//        responseProduct.setProductName(product.getProductName());
//        responseProduct.setPrice(product.getPrice());
//        responseProduct.setDescription(product.getDescription());
//        responseProduct.setCategory(product.getCategory());

        List<Product> products = productRepository.findAll();
        Product product =  products.stream().filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        ProductDto responseProduct = new ProductDto();
        responseProduct.setId(product.getId());
        responseProduct.setProductName(product.getProductName());
        responseProduct.setPrice(product.getPrice());
        responseProduct.setDescription(product.getDescription());
        responseProduct.setCategory(product.getCategory());

        return responseProduct;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(UUID id) {
        List<Product> products = productRepository.findAll();
        Product product =  products.stream().filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()->new ResourceNotFoundException("Product","id",id));
//         Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
         productRepository.delete(product);

    }
}
