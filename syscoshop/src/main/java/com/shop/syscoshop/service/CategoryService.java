package com.shop.syscoshop.service;

import com.shop.syscoshop.payload.CategoryDto;

import java.util.List;


public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getCategories();
    void deleteCategory(long id);


}
