package com.cha103g5.membernotice.model;

public class WebSocketMessage {

    private String message;
    private String targetUser; 

    public WebSocketMessage() {
    }

    public WebSocketMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
    	this.message = message;
    }
    
    public String getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}

}
