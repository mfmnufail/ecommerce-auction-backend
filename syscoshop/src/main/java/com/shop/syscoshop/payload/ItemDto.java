package com.shop.syscoshop.payload;


import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    @NotNull
    private Long productID;
    @NotNull
    private Float quantity;
}
