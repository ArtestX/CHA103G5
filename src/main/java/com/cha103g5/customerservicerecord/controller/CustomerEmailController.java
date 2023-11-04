package com.cha103g5.customerservicerecord.controller;

import com.cha103g5.customerservicerecord.model.CustomerEmail;
import com.cha103g5.customerservicerecord.service.CustomerMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerEmailController {

    @Autowired
    private CustomerMailService mailService;

    @PostMapping("/customer/mail.do")
    public void sendMail(@RequestBody CustomerEmail customerEmail){
        System.out.println("mail succeed!!!");
        try {
            mailService.sendCustomerMail(customerEmail);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
