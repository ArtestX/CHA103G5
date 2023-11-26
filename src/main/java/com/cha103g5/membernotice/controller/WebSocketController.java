package com.cha103g5.membernotice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
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
	    System.out.println("Received message - Title: " + message.getTitle() + ", Content: " + message.getContent() +",time:" + message.getFormattedTimestamp());        
	    
	 // 將訊息存進 Redis
	    Map<String, String> bellText = new HashMap<>();
	    bellText.put("Title:" + message.getTitle() , "Content: " + message.getContent() + ", Timestamp: " + message.getFormattedTimestamp());

	    Jedis jedis = new Jedis("localhost", 6379);
	  
	    jedis.select(15);
	    Gson gson = new Gson();
	    String bellmessage = gson.toJson(bellText);

	    // 使用固定的列表名稱 "messages"
	    String listName = message.getTitle();

	    // 將新的消息推送到列表的頭部
	    jedis.lpush(listName, bellmessage);

	    System.out.println("Message stored in Redis successfully");

	    jedis.close();
	    return new WebSocketMessage(message.getTitle(), message.getContent(), message.getFormattedTimestamp());
	}
   
}

