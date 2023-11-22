package com.cha103g5.membernotice.model;

public class WebSocketMessage {

//    private String targetUser; 
    private String title;
    private String content;

    public WebSocketMessage() {
    }
    
    public WebSocketMessage(String title, String content) {
        this.title = title;
        this.content = content;
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

//	public String getTargetUser() {
//		return targetUser;
//	}
//
//	public void setTargetUser(String targetUser) {
//		this.targetUser = targetUser;
//	}

}
