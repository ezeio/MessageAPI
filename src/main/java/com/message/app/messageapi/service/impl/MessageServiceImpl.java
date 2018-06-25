package com.message.app.messageapi.service;

import com.message.app.messageapi.exception.MessageNotFoundException;
import com.message.app.messageapi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.message.app.messageapi.model.*;


@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;

    public Long createMessage(Message message) {
        return messageRepository.save(message).getId();
    }

    public Message getMessage(Long id) {
        return  messageRepository.findById(id).orElseThrow(MessageNotFoundException::new);
    }
}
