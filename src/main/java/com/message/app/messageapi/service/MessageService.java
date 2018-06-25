package com.message.app.messageapi.service;

import com.message.app.messageapi.model.Message;

public interface MessageService {

    Long createMessage(Message message);
    Message getMessage(Long id);

    void updateMessage(Message message, Long messageId);
}
