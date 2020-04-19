package it.unimi.kata.implementations;

import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.Employee;

import java.util.List;

public class EmailServiceImpl implements EmailService {

    String subject;
    String text;

    public EmailServiceImpl(String subject, String text){
        this.subject = subject;
        this.text = text;
    }

    public String getSubject(){ return subject;}

    public String getText() { return text;}

    @Override
    public String sendEmail(String name){
        return subject.concat(text).concat(name).concat("!");
    }
}
