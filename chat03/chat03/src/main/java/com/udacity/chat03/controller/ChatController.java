package com.udacity.chat03.controller;

import com.udacity.chat03.model.MessageForm;
import com.udacity.chat03.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat03")
public class ChatController {
    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageService.getChatMessages());
        return "chat03";
    }

    @PostMapping
    public String postChatMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageService.addMessage(messageForm);
        messageForm.setMessageText("");
        model.addAttribute("greetings", this.messageService.getChatMessages());
        return "chat03";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
