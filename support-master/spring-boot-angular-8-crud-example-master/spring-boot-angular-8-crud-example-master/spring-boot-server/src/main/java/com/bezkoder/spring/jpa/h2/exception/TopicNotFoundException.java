package com.bezkoder.spring.jpa.h2.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(String message) {
        super(message);
    }
}
