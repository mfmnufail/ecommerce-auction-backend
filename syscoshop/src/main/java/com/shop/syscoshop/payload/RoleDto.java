package com.shop.syscoshop.payload;


import com.shop.syscoshop.entity.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotNull
    private Roles roleName;
}
