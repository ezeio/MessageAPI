package com.message.app.messageapi.service;

import com.message.app.messageapi.model.Message;

import java.util.List;

public interface MessageService {

    Long createMessage(Message message);

    Message getMessage(Long id);

    List<Message> getMessages(Integer limit);

    void updateMessage(Message message, Long messageId);
}
