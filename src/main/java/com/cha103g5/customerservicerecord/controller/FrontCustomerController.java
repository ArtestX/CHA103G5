package com.cha103g5.customerservicerecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontCustomerController {

    @GetMapping("/customer/banner")
    public String ShowBanner(){
        return "customer/banner";
    }

    @GetMapping("/customer/frontCustomer")
    public String ShowFrontCustomer(){
        return "customer/frontCustomer";
    }
}
