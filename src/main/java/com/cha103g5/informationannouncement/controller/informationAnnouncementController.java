package com.cha103g5.informationannouncement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class informationAnnouncementController {

    @PostMapping
    public String insert() {
        return "新增成功";
    }
}
