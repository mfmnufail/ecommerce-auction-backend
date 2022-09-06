package com.shop.syscoshop.service.impl;

import com.shop.syscoshop.entity.Category;
import com.shop.syscoshop.exception.ResourceNotFoundException;
import com.shop.syscoshop.payload.CategoryDto;
import com.shop.syscoshop.repository.CategoryRepository;
import com.shop.syscoshop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.save(modelMapper.map(categoryDto, Category.class));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(modelMapper.map(category, CategoryDto.class));
        }
        return categoryDtoList;
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.delete(
                categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id)));
    }
}
