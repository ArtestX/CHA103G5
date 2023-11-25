package com.cha103g5.membernotice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import redis.clients.jedis.Jedis;

@Controller
public class MemberNoticeController {

    @GetMapping("/notices")
    public String getNotices(Model model) {
        // 讀取 Redis 中的通知數據
        List<Map<String, String>> noticeMessages = new ArrayList<>();
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.select(15);  // 選擇 Redis 中的數據庫

        // 在這裡假設通知的標題就是 Redis 中的鍵
        for (String key : jedis.keys("*")) {
          
            Map<String, String> message = jedis.hgetAll(key);

            message.put("Title", key);

            noticeMessages.add(message);
        }

        jedis.close();

        // 將通知數據傳遞到前端
        model.addAttribute("noticeMessages", noticeMessages);
        
     // 添加日志
        System.out.println("Number of notices: " + noticeMessages.size());

        return "/member/frontMemberNotice";  // 返回前端頁面的名稱（假設為 notices.jsp）
    }

}
