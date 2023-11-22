package com.cha103g5.cart.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartVO {
    @Id
    private Integer cartNo; // 購物車主鍵
    private Integer memberNo; // 會員主鍵

    @OneToMany
    private List<CartItemVO> items; // 購物車項目

    public Integer getCartNo() {
        return cartNo;
    }

    public void setCartNo(Integer cartNo) {
        this.cartNo = cartNo;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public List<CartItemVO> getItems() {
        return items;
    }

    public void setItems(List<CartItemVO> items) {
        this.items = items;
    }
}
