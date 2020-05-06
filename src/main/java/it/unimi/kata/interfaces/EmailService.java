package it.unimi.kata.interfaces;

import java.util.List;

public interface EmailService {
    String getEmailFrom();
    String getEmailTo();
    String getObject();
    String getText();
    void sendEmail(String emailTo, String object, String text);
}
