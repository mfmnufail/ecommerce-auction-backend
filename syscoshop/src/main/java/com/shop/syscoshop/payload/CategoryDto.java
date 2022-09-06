package com.shop.syscoshop.payload;


import com.sun.istack.NotNull;
import lombok.Data;


@Data
public class CategoryDto {

    private long categoryId;
    @NotNull
    private String categoryName;

}
