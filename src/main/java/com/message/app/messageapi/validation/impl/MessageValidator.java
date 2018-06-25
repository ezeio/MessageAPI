package com.message.app.messageapi.validation.impl;

import com.message.app.messageapi.model.Message;

public interface MessageValidator {

    boolean isInvalid(Message message);
}
