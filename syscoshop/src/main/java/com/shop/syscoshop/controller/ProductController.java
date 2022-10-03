package com.shop.syscoshop.controller;

import com.shop.syscoshop.entity.Product;

import com.shop.syscoshop.payload.ProductDto;
import com.shop.syscoshop.service.ProductService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")

@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductId(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductCategoryId(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(productService.getProductsByCategoryId(id),HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable(name = "id") long id){
//        return new ResponseEntity<>(productService.updateProduct(productDto,id),HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Proudct deleted",HttpStatus.OK);
    }
}
