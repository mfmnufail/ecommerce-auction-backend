package com.shop.syscoshop.repository;

import com.shop.syscoshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Long> {
}
