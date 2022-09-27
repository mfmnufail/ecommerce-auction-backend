package com.shop.syscoshop.payload;


import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    @NotNull
    private String cartName;
}
