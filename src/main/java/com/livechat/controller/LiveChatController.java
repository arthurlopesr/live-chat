package com.livechat.controller;

import com.livechat.domain.ChatInput;
import com.livechat.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutput newMessage(ChatInput input) {
        String formattedMessage = HtmlUtils.htmlEscape(String.format("%s: %s", input.user(), input.message()));
        return new ChatOutput(formattedMessage);
    }
}
