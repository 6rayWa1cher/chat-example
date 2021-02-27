package com.a6raywa1cher.chatexample.websocket;

import com.a6raywa1cher.chatexample.websocket.req.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/chat")
public class ChatController {
    @MessageMapping("/send")
    @SendTo("/topic/msg")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }
}
