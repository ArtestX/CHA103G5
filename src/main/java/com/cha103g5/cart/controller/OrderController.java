package com.cha103g5.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
public class OrderController {

    @GetMapping("/storeOrderInfo/{memberNo}/{quantity}/{price}/{totalPrice}")
    public ModelAndView storeOrderInfo(@PathVariable Integer memberNo, @PathVariable Integer quantity, @PathVariable BigDecimal price, @PathVariable BigDecimal totalPrice, HttpSession session) {

        session.setAttribute("memberNo", memberNo);
        session.setAttribute("quantity", quantity);
        session.setAttribute("price", price);
        session.setAttribute("totalPrice", totalPrice);

        return new ModelAndView("redirect:/order");
    }
}