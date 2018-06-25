package com.message.app.messageapi.service.impl;

import com.message.app.messageapi.exception.EmptyDatabaseException;
import com.message.app.messageapi.exception.MessageInvalidPropertyException;
import com.message.app.messageapi.exception.MessageNotFoundException;
import com.message.app.messageapi.model.Message;
import com.message.app.messageapi.repository.MessageRepository;
import com.message.app.messageapi.service.MessageService;
import com.message.app.messageapi.validation.impl.MessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageValidator messageValidator;

    @Override
    public Long createMessage(Message message) {
        if (null == message || messageValidator.isInvalid(message))
            throw new MessageInvalidPropertyException();

        message.setCreationTime(LocalDateTime.now());
        return messageRepository.save(message).getId();
    }

    @Override
    public Message getMessage(Long id) {
        return messageRepository.findById(id).orElseThrow(MessageNotFoundException::new);
    }

    @Override
    public List<Message> getMessages(Integer limit) {
        Pageable pageRequest = createPageRequestDescendingByModTime(limit);

        Page<Message> messagesPage = messageRepository.findAll(pageRequest);
        if (messagesPage.getContent().size() < 1) throw new EmptyDatabaseException();

        return messagesPage.getContent();
    }

    @Override
    public void updateMessage(Message message, Long messageId) {

        if (null == message || messageValidator.isInvalid(message))
            throw new MessageInvalidPropertyException();
        int numberOfRows = messageRepository.updateMessageDetailsById(message.getTitle(), message.getMessage(), messageId);
        if (numberOfRows < 1)
            throw new MessageNotFoundException();

    }

    private Pageable createPageRequestDescendingByModTime(Integer limit) {
        return PageRequest.of(0, limit, Sort.Direction.DESC, "modifiedTime");
    }

}
