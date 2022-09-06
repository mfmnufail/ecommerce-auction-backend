package com.shop.syscoshop.repository;

import com.shop.syscoshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryByCategoryName(String categoryName);
    Boolean existsCategoryByCategoryName(String categoryName);
}
