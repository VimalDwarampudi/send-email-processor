package com.codebigbear.processor.services;

public interface EmailService {
    void sendHTML(String from, String to, String subject, String body);
}
