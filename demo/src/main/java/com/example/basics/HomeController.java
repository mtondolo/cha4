package com.example.basics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute ("newMessage")MessageForm newMessage, Model model){
        model.addAttribute("messages", this.messageService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute ("newMessage") MessageForm messageForm, Model model){
        messageService.addMessage(messageForm.getText());
        model.addAttribute("messages", messageService.getMessages());
        messageForm.setText("");
        return "home";
    }
}
