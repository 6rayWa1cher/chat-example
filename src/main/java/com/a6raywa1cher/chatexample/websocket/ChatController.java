package com.a6raywa1cher.chatexample.websocket;

import com.a6raywa1cher.chatexample.websocket.req.IncomeChatMessage;
import com.a6raywa1cher.chatexample.websocket.res.OutcomeChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@MessageMapping("/chat")
public class ChatController {
    @MessageMapping("/send")
    @SendTo("/topic/msg")
    public OutcomeChatMessage sendGlobalMessage(@Payload @Valid IncomeChatMessage incomeChatMessage, Principal principal) {
        return new OutcomeChatMessage(incomeChatMessage.getBody(), principal.getName());
    }

    @MessageMapping("/dm_send/{username}")
    @SendTo("/topic/dm/{username}")
    public OutcomeChatMessage sendDirectMessage(@Payload @Valid IncomeChatMessage incomeChatMessage, Principal principal) {
        return new OutcomeChatMessage(incomeChatMessage.getBody(), principal.getName());
    }
}
