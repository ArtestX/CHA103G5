package com.cha103g5.cart.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/cart")
    public String cartPage() {
        return "cart";
    }
}
