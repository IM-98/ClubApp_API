package com.api.pythagore.domain.service.email;

public interface EmailSender {
    void send(String to, String email);
}
