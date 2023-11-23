package com.cha103g5.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartVO, Integer> {
    // 自定義的方法
}
