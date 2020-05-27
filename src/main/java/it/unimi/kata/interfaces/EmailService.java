package it.unimi.kata.interfaces;

public interface EmailService {
  String getEmailFrom();

  String getEmailTo();

  String getObject();

  String getText();

  void sendEmail(String emailTo, String object, String text);
}
