package it.unimi.kata.implementations;

import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.Employee;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;


public class EmailServiceImpl implements EmailService {

    public String getEmailFrom() {
        return emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public String getObject() {
        return object;
    }

    public String getText() {
        return text;
    }

    String emailTo;
    String emailFrom;
    String object;
    String text;

    public EmailServiceImpl(String emailFrom){
        this.emailFrom = emailFrom;
    }

    @Override
    public void sendEmail(String emailTo, String object, String text){
        this.emailTo = emailTo;
        this.object = object;
        this.text = text;
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", "localhost");
//        properties.setProperty("mail.smtp.port", "1025");
//        Session session = Session.getDefaultInstance(properties);
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(emailFrom));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
//            message.setSubject("Hello");
//            message.setText("Hey, ignore this email, this is just an example");
//            Transport.send(message);
//            System.out.println("Sent Successfully");
//        }
//        catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
    }
}
