package com.shop.syscoshop.payload;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProductDto {
    private long id;
    @NotNull
    private String productName;
    private String description;
    @NotNull
    private float price;
    @NotNull
    private String category;

}
