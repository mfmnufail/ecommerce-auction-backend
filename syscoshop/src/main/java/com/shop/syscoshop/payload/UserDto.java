package com.shop.syscoshop.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mapping.KPropertyPathExtensionsKt;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    @NotNull
    private String fullName;
    @NotNull
    private String email;
    @NotNull
    private String password;

}
