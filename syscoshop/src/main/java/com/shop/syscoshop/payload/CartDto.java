package com.shop.syscoshop.payload;


import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {


    @NotNull
    private Float quantity;

    @NotNull
    private Float price;

    @NotNull
    private Long productId;

    @NotNull
    private Long userId;
}
