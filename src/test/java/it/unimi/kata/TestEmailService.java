package it.unimi.kata;

import it.unimi.kata.implementations.EmailServiceImpl;
import it.unimi.kata.implementations.EmployeeImpl;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestEmailService {

    EmailServiceImpl es;
    Employee emp;

    @BeforeEach
    public void setUp(){
        String completeString;
        es = mock(EmailServiceImpl.class);
        emp = setUpEmployee("Mario", "Bros", LocalDate.of(1996, 12, 29), "mario.bros@mail.it");
        when(es.getSubject()).thenReturn("Happy Birthday! ");
        when(es.getText()).thenReturn("Happy Birthday, dear ");
        completeString = "Happy Birthday! Happy Birthday, dear "+ emp.getName()+"!";
        when(es.sendEmail(emp.getName())).thenReturn(completeString);
    }

    @Test
    public void correctSubject(){
        assertThat(es.getSubject()).isEqualTo("Happy Birthday! ");
    }

    @Test
    public void correctText(){
        assertThat(es.getText()).isEqualTo("Happy Birthday, dear ");
    }

    @Test
    public void correctEmailText(){
        assertThat(es.sendEmail(emp.getName())).isEqualTo(es.getSubject() + es.getText() + emp.getName() + "!");
    }


    private Employee setUpEmployee(String name, String surname, LocalDate birthday, String email){
        Employee emp = mock(EmployeeImpl.class);
        when(emp.getName()).thenReturn(name);
        when(emp.getSurname()).thenReturn(surname);
        when(emp.getBirthdayDate()).thenReturn(birthday);
        when(emp.getEmail()).thenReturn(email);
        return emp;
    }
}
