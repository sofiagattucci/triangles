package it.unimi.kata.implementations;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.EmployeeRepository;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BDSModule extends AbstractModule {
    String object = "Happy Birthday!";
    String text = "Happy Birthday, dear ";
    EmployeeRepository er;
    EmailService es;

    public BDSModule(EmployeeRepository er, EmailService es){
        this.er = er;
        this.es = es;
    }

    @Override
    protected void configure(){
//        bind(EmployeeRepository.class).to(EmployeeRepositoryImpl.class);
//        bind(EmailService.class).to(EmailServiceImpl.class);
        bindConstant()
                .annotatedWith(Names.named("path"))
                .to("repo.txt");
        bindConstant()
                .annotatedWith(Names.named("emailFrom"))
                .to("sofia.gattucci@studenti.unimi.it");
    }

    @Provides
    EmployeeRepository provideER(){
//        er = mock(EmployeeRepository.class);
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
        return er;
    }

    @Provides
    EmailService provideEMS(){
//        es = mock(EmailServiceImpl.class);
        when(es.getObject()).thenReturn(object);
        when(es.getText()).thenReturn(text);
        when(es.getEmailFrom()).thenReturn("sofia.gattucci@studenti.unimi.it");
        return es;
    }
}