package com.a6raywa1cher.chatexample.websocket.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChatMessage {
    @NotBlank
    private String body;

    @NotBlank
    private String author;
}
