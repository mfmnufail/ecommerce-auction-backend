package com.shop.syscoshop.payload;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    @NotNull
    private String productName;
    private String description;
    @NotNull
    private float price;
    @NotNull
    private Long categoryId;
    @NotNull
    private Long cartId;

}
