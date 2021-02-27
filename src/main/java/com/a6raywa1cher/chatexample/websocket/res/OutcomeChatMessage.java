package com.a6raywa1cher.chatexample.websocket.res;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutcomeChatMessage {
    private String body;

    private String author;
}
