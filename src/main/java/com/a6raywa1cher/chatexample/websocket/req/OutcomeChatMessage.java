package com.a6raywa1cher.chatexample.websocket.req;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class OutcomeChatMessage {
    private String author;

    private String body;

    private ZonedDateTime time;
}
