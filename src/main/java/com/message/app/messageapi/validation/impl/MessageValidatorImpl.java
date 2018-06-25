package com.message.app.messageapi.validation;

import com.message.app.messageapi.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageValidator {

    public boolean isValid(Message message){
        boolean isValid = hasTitle(message) || hasMessage(message);

        return isValid;
    }

    private boolean hasTitle(Message message){
        return message.getTitle().equals(null) || message.getTitle().isEmpty()?false:true;
    }

    private boolean hasMessage(Message message){
        return message.getMessage().equals(null) || message.getMessage().isEmpty()?false:true;
    }
}
