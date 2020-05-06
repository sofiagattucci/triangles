package it.unimi.kata;

import it.unimi.kata.implementations.EmailServiceImpl;
import it.unimi.kata.implementations.EmployeeImpl;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestEmailService {

    EmailServiceImpl es;
    Employee emp;
    String object = "Happy Birthday!";
    String text = "Happy Birthday, dear ";

    @BeforeEach
    public void setUp(){
        es = new EmailServiceImpl("sofia.gattucci@mail.it");
        emp = setUpEmployee("Mario", "Bros", LocalDate.of(1996, 12, 29), "mario.bros@mail.it");
        es.sendEmail(emp.getEmail(), object, text+ emp.getName()+"!");
    }

//    @Test
//    public void correctEmailSend(){
//        verify(es).sendEmail(emp.getEmail(), object, text + emp.getName()+"!");
//    }

    @Test
    public void correctText(){
        es.sendEmail(emp.getEmail(), object, text+ emp.getName()+"!");
        assertThat(es.getText()).isEqualTo(text + emp.getName() + "!");
    }

    @Test
    public void correctObject(){
        es.sendEmail(emp.getEmail(), object, text+ emp.getName()+"!");
        assertThat(es.getObject()).isEqualTo(object);
    }

    @Test
    public void correctSender(){
        es.sendEmail(emp.getEmail(), object, text+ emp.getName()+"!");
        assertThat(es.getEmailFrom()).isEqualTo("sofia.gattucci@mail.it");
    }


    private Employee setUpEmployee(String name, String surname, LocalDate birthday, String email){
        Employee emp = new EmployeeImpl(name, surname, birthday, email);
        return emp;
    }
}
