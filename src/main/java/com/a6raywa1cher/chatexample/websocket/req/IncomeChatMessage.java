package com.a6raywa1cher.chatexample.websocket.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class IncomeChatMessage {
    @NotBlank
    private String body;
}
