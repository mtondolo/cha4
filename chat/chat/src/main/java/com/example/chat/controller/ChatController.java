package com.example.chat.controller;

import com.example.chat.model.ChatForm;
import com.example.chat.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/chat")
public class ChatController {
    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

     @GetMapping
    public String getChatPage(ChatForm chatForm, Model model){
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
         return "chat";
    }
    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        this.messageService.addMessage(chatForm);
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        chatForm.setMessageText("");
        return "chat";
    }

    @ModelAttribute("allMessageType")
    public String[] allMessageTypes(){
        return new String[] {"Say", "Shout", "Whisper"};
    }

}
