package com.message.app.messageapi.service.impl;

import com.message.app.messageapi.exception.MessageNotFoundException;
import com.message.app.messageapi.repository.MessageRepository;
import com.message.app.messageapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.message.app.messageapi.model.*;

import java.time.LocalDateTime;


@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Long createMessage(Message message) {
        message.setCreationTime(LocalDateTime.now());
        return messageRepository.save(message).getId();
    }

    @Override
    public Message getMessage(Long id) {
        return  messageRepository.findById(id).orElseThrow(MessageNotFoundException::new);
    }

    @Override
    public void updateMessage(Message message, Long messageId) {
        messageRepository.setMessageDetailsById(message.getTitle(), message.getMessage(), messageId);
    }


}
