package com.udacity.chat03.model;

public class MessageForm {
    private String messageText;
    private String messageType;

    public String getMessageText() {
        return messageText;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
