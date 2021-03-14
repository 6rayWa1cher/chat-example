package com.a6raywa1cher.chatexample.websocket;

import com.a6raywa1cher.chatexample.websocket.req.IncomeChatMessage;
import com.a6raywa1cher.chatexample.websocket.req.OutcomeChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.ZonedDateTime;

@Controller
@MessageMapping("/chat")
public class ChatController {
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public OutcomeChatMessage sendMessage(IncomeChatMessage message) {
        return new OutcomeChatMessage(message.getAuthor(), message.getBody(), ZonedDateTime.now());
    }
}
