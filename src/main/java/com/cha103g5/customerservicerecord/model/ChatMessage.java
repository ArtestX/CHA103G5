package com.cha103g5.customerservicerecord.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ChatMessage {

    private String type;

    private String sender;

    private String receiver;

    private String message;

    private String time;

    private String status;

}
