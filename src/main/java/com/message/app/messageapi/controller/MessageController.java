package com.message.app.messageapi.controller;

import com.message.app.messageapi.model.Message;
import com.message.app.messageapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;


    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,Long> addMessage(@RequestBody Message message) {

        Long id = messageService.createMessage(message);
        Map<String,Long> messageId = new HashMap<>();
        messageId.put("id",id);
        return messageId;
    }

    @GetMapping("/message/{messageId}")
    public Message getMessage(@PathVariable Long messageId) {

        return messageService.getMessage(messageId);
    }

    @GetMapping("/messages/")
    public List<Message> getMessages(
            @RequestParam(value = "limit") Integer limit) {

        return messageService.getMessages(limit);
    }

    @PutMapping(value = "/message/{messageId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateMessage(@RequestBody Message message, @PathVariable("messageId") Long id) {
        messageService.updateMessage(message, id);
        return ResponseEntity.ok("message updated");
    }
}
