package com.shop.syscoshop.payload;


import com.sun.istack.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private long categoryId;
    @NotNull
    private String categoryName;

}
