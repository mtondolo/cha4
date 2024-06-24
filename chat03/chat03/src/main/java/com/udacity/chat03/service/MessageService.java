package com.udacity.chat03.service;

import com.udacity.chat03.model.MessageForm;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MessageService {
    private List<MessageForm> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(MessageForm messageForm) {
        MessageForm newMessage = new MessageForm();
        newMessage.setMessageText(messageForm.getMessageText());
        switch (messageForm.getMessageType()){
            case "Say":
                newMessage.setMessageText(messageForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(messageForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(messageForm.getMessageText().toLowerCase());
                break;
        }
        this.messages.add(newMessage);
    }

    public List<MessageForm> getChatMessages() {
        return messages;
    }
}
