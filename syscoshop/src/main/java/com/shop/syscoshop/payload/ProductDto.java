package com.shop.syscoshop.payload;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String productName;
    private String description;
    private float price;
    private String category;

}
