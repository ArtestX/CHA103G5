package com.cha103g5.cart.service;

import com.cha103g5.cart.dao.CartItemVO;
import com.cha103g5.cart.dao.CartRepository;
import com.cha103g5.cart.dao.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartVO createCart(CartVO cart) {
        // 在這裡實現創建購物車的邏輯
        return cartRepository.save(cart);
    }

    public Optional<CartVO> getCartById(Integer id) {
        return cartRepository.findById(id);
    }

    public CartVO updateCart(CartVO cart) {
        // 在這裡實現更新購物車的邏輯
        return cartRepository.save(cart);
    }

    public void deleteCart(Integer id) {
        // 在這裡實現刪除購物車的邏輯
        cartRepository.deleteById(id);
    }

    public boolean addProductToCart(Integer memberId, Integer productId, Integer quantity) {
        Optional<CartVO> cartOptional = getCartById(memberId);
        if (!cartOptional.isPresent()) {
            // 如果找不到購物車，則創建一個新的購物車
            CartVO newCart = new CartVO();
            newCart.setMemberNo(memberId);
            newCart.setItems(new ArrayList<>());
            cartRepository.save(newCart);
            cartOptional = Optional.of(newCart);
        }

        CartVO cart = cartOptional.get();
        CartItemVO newItem = new CartItemVO();
        newItem.setProductNo(productId);
        newItem.setQuantity(quantity);

        List<CartItemVO> items = cart.getItems();
        items.add(newItem);
        cart.setItems(items);

        cartRepository.save(cart);
        return true;
    }
}
