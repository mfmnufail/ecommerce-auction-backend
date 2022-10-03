package com.shop.syscoshop.service.impl;

import com.shop.syscoshop.payload.CartDto;

public interface CartService {

    CartDto crateCart(Long productId);

    CartDto getCartByUserId(Long userId);

    CartDto updateCart(CartDto cartDto);

    void deleteCart(Long productId );
}
