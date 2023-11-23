package com.cha103g5.membernotice.model;

public class WebSocketMessage {

    private String title;
    private String content;
    private long timestamp;

    public WebSocketMessage() {
        this.timestamp = System.currentTimeMillis(); // 使用當前時間戳初始化
    }

    public WebSocketMessage(String title, String content,long timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = System.currentTimeMillis(); // 使用當前時間戳初始化
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
        this.timestamp = timestamp;
    }
}
