package com.message.app.messageapi.validation.impl;

import com.message.app.messageapi.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageValidatorImpl implements MessageValidator {

    @Override
    public boolean isInvalid(Message message){
        boolean isValid = hasTitle(message) || hasMessage(message);

        return isValid;
    }

    private boolean hasTitle(Message message){
        String title = message.getTitle();
        return null == title || title.equals(null) || title.isEmpty();
    }

    private boolean hasMessage(Message message){
        String aMessage = message.getMessage();
        return null == aMessage || aMessage.equals(null) || aMessage.isEmpty();
    }
}
