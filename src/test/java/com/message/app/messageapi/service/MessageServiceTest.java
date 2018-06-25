package com.message.app.messageapi.service;

import com.message.app.messageapi.exception.MessageNotFoundException;
import com.message.app.messageapi.model.Message;
import com.message.app.messageapi.repository.MessageRepository;
import com.message.app.messageapi.service.impl.MessageServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    MessageRepository messageRepository;

    @InjectMocks
    MessageServiceImpl messageService = new MessageServiceImpl();


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void createMessageWithValidProperties() {

        // Given
        Message message = new Message("FIFA", "The world cup will begin next week during the round of 16");
        when(messageRepository.save(message)).thenReturn(message);

        // When
        Long id = messageService.createMessage(message);

        // Then
        assertEquals(new Long(1), id);
    }

    @Test
    public void whenAMessageIsRequested_thenTheMessageIsReturned() {
        //Given
        Message message = new Message("Head line", "Boyota away!");
        Long id = new Long(1);
        when(messageRepository.findById(id)).thenReturn(Optional.of(message));

        //When
        Message returnedMessage = messageService.getMessage(id);

        //Then
        Assert.assertEquals(message.getMessage(), returnedMessage.getMessage());
        Assert.assertEquals(message.getTitle(), returnedMessage.getTitle());
    }

    @Test(expected = MessageNotFoundException.class)
    public void whenANoneExistentMessageIsRequested_thenExceptionIsThrown() {
        //Given
        Message message = new Message("Animal farm", "That's an old book! find something new to read");
        Long id = new Long(2);
        when(messageRepository.findById(id)).thenReturn(Optional.empty());

        //When
        messageService.getMessage(id);
    }

    @Test
    public void whenIModifyAMessage_thenTheModifiedMessageIsReturned() {

        //Given
        Message message1 = new Message("North England", "It was raining here last night");
        Long messageId = new Long(1);

        //When

        when(messageRepository.updateMessageDetailsById(
                "North England",
                "It was raining here last night",
                messageId)).thenReturn(1);

        //Then
        messageService.updateMessage(message1, new Long(1));
    }


}