package com.cha103g5.membernotice.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WebSocketMessage {

    private String title;
    private String content;
    private long timestamp;

    public WebSocketMessage() {
        this.timestamp = System.currentTimeMillis(); // 使用當前時間戳初始化
    }

    public WebSocketMessage(String title, String content,String formattedDateTime) {
        this.title = title;
        this.content = content;
        this.timestamp = System.currentTimeMillis(); // 使用當前時間戳初始化
    }
    
	 // 新增一個方法用於獲取格式化的日期時間字符串
	    public String getFormattedTimestamp() {
	        Instant instant = Instant.ofEpochMilli(timestamp);
	        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd  HH:mm:ss");
	        String formattedDateTime = dateTime.format(formatter); // 格式化日期時間
	        return formattedDateTime;
	    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = System.currentTimeMillis();
    }
}
