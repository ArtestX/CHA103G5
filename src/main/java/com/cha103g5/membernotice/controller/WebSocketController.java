package com.cha103g5.membernotice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import com.cha103g5.membernotice.model.WebSocketMessage;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@Controller
@EnableWebSocketMessageBroker
public class WebSocketController {
    
	@MessageMapping("/sendToAll")
    @SendTo("/topic/messages")
	public WebSocketMessage sendToAll(WebSocketMessage message) {
		try {
	        System.out.println("Received message - Title: " + message.getTitle() + ", Content: " + message.getContent() + ", Timestamp: " + message.getFormattedTimestamp());
	        
	        // 將訊息存進 Redis
	        Map<String, String> bellText = new HashMap<>();
	        bellText.put("bellmessage", "Title: " + message.getTitle() + ", Content: " + message.getContent() + ", Timestamp: " + message.getFormattedTimestamp());

	        Jedis jedis = new Jedis("localhost", 6379);
	        String pingResult = jedis.ping();
	        System.out.println("Ping result: " + pingResult);
	        jedis.select(3);
	        Gson gson = new Gson();
	        String bellmessage = gson.toJson(bellText);

	        // 使用 Timestamp 作為唯一標識符
	        String messageId = message.getFormattedTimestamp();

	        // 檢查 Redis 是否成功存儲
	        if ("OK".equals(jedis.set(messageId, bellmessage))) {
	        	jedis.set(messageId, bellmessage);
	            System.out.println("Message stored in Redis successfully");
	        } else {
	            System.out.println("Failed to store message in Redis");
	        }

	        jedis.close();

	        return new WebSocketMessage(message.getTitle(), message.getContent(), message.getFormattedTimestamp());
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; // 返回 null 或其他錯誤處理方式
	    }
	    
	}
    
}

