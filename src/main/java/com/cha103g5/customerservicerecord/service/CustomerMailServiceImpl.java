package com.cha103g5.customerservicerecord.service;

import com.cha103g5.customerservicerecord.model.CustomerEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomerMailServiceImpl implements CustomerMailService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendCustomerMail(CustomerEmail customerEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fctestgg@gmail.com");
        message.setTo("fctestgg@gmail.com");
        message.setSubject("[浪愛有家] 客服郵件");
        message.setText(
                "問題類別：" + customerEmail.getCategory()+"\n\n"+
                "寄件人姓名：" + customerEmail.getName()+"\n\n"+
                "寄件人信箱：" + customerEmail.getUsermail()+"\n\n"+
                "---------------寄件人留言------------------\n\n"+
                customerEmail.getContent()+"\n\n"+
                "---------------------------------------------");

        mailSender.send(message);
    }
}
