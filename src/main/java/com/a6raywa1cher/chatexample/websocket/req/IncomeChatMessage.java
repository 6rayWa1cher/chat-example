package com.a6raywa1cher.chatexample.websocket.req;

import lombok.Data;

@Data
public class IncomeChatMessage {
    private String author;

    private String body;
}
