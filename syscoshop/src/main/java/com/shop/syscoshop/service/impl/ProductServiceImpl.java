package com.shop.syscoshop.service.impl;

import com.shop.syscoshop.entity.Category;
import com.shop.syscoshop.entity.Product;
import com.shop.syscoshop.exception.ResourceNotFoundException;
import com.shop.syscoshop.payload.ProductDto;
import com.shop.syscoshop.repository.CategoryRepository;
import com.shop.syscoshop.repository.ProductRepository;
import com.shop.syscoshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Category category =   categoryRepository.findById(productDto.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException("category", "id", productDto.getCategoryId()));
        product.setCategory(category);
        Product newProduct = productRepository.save(product);
        return mapToDto(newProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto getProductById(long id) {
        List<Product> products = productRepository.findAll();
        Product product = products.stream().filter(e -> e.getProductId() == id).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id));
        return mapToDto(product);
    }

//    @Override
//    public ProductDto updateProduct(ProductDto productDto, long id) {
//        Product product =
//                productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
//        product.setProductName(productDto.getProductName());
//        product.setPrice(productDto.getPrice());
//        product.setDescription(productDto.getDescription());
//        product.setCategory(productDto.getCategory());
//        productRepository.save(product);
//        return mapToDto(product);
//    }

    @Override
    public void deleteProduct(long id) {
        Product product =
                productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProductsByCategoryId(long categoryId) {
        return productRepository.findAllByCategoryCategoryId(categoryId);
    }


    private Product mapToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    private ProductDto mapToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
