package com.message.app.messageapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Message not found for the provided id")
public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException(){}
}
