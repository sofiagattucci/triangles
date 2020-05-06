package it.unimi.kata;

import com.google.inject.Guice;
import com.google.inject.Injector;
import it.unimi.kata.implementations.*;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TestBDSInjection {

    BirthdayServiceImpl bds;
    EmailService ems;
    EmployeeRepository emp;
    String object = "Happy Birthday!";
    String text = "Happy Birthday, dear ";

    @BeforeEach
    public void setUp(){
        emp = mock(EmployeeRepository.class);
        createRep(emp);
        ems = mock(EmailService.class);
        createEmailService(ems);
        Injector inj = Guice.createInjector(new BDSModule() {
            @Override
            protected void configure() {
                bind(EmployeeRepository.class).toInstance(emp);
                bind(EmailService.class).toInstance(ems);
            }
        });
        bds = inj.getInstance(BirthdayServiceImpl.class);
    }

    @Test
    void simpleTestEmailService() {
        bds.sendGreetings(12, 29);
        verify(ems).sendEmail("luigi.bros@mail.it", object, text + "Luigi!");
    }

    @Test
    void simpleTestEmployeeRep() {
        bds.sendGreetings(12, 29);
        verify(emp).findEmployeesBornOn(12, 29);
    }

    @Test
    void simpleBDSTest(){
        bds.sendGreetings(12, 3);
        assertThat(bds.getEmployeesBornOn())
                .extracting(Employee::getName)
                .contains("Peach", "Daisy");

    }

    void createRep(EmployeeRepository er){
        when(er.findEmployeesBornOn(12, 29))
                .thenReturn(Arrays.asList(
                        new EmployeeImpl(
                                "Mario", "Bros", LocalDate.parse("1996-12-29"),"mario.bros@mail.it"),
                        new EmployeeImpl(
                                "Luigi", "Bros", LocalDate.parse("1996-12-29"),"luigi.bros@mail.it")
                ));

        when(er.findEmployeesBornOn(12, 3))
                .thenReturn(Arrays.asList(
                        new EmployeeImpl(
                                "Peach", "ToadStool", LocalDate.parse("1994-12-03"),"peach.toadStool@mail.it"),
                        new EmployeeImpl(
                                "Daisy", "ToadStool", LocalDate.parse("1996-12-03"),"daisy.toadStool@mail.it")
                ));
    }

    void createEmailService(EmailService es){
        when(es.getObject()).thenReturn(object);
        when(es.getText()).thenReturn(text);
    }
}
