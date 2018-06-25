package com.message.app.messageapi.controller;

import com.message.app.messageapi.model.Message;
import com.message.app.messageapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(path = "/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Long addMessage(@RequestBody Message message){

        return messageService.createMessage(message);
    }

    @ResponseBody
    @RequestMapping(path = "/message/{messageId}", method = RequestMethod.GET)
    public Message getMessage(@PathVariable Long messageId){

        return messageService.getMessage(messageId);
    }


}
