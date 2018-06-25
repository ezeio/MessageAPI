package com.message.app.messageapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Message property can not be null")
public class MessageInvalidPropertyException extends RuntimeException {

    public MessageInvalidPropertyException() {
    }
}
