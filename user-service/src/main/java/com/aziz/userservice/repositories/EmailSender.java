package com.aziz.userservice.repositories;

public interface EmailSender {
    void send(String to, String email);
}
