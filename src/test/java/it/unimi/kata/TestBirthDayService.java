package it.unimi.kata;

import it.unimi.kata.implementations.*;
import it.unimi.kata.interfaces.*;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TestBirthDayService {

    BirthdayServiceImpl bs;
    List<Employee> listOfEmployees;
    EmailServiceImpl ems;
    EmployeeRepositoryImpl er;
    String object = "Happy Birthday!";
    String text = "Happy Birthday, dear ";

    @BeforeEach
    public void setUp(){
        listOfEmployees = new ArrayList<>();
        createEmployee("Mario", "Bros", LocalDate.of(1996, 12, 29), "mario.bros@mail.it");
        createEmployee("Luigi", "Bros", LocalDate.of(1996, 12, 29), "luigi.bros@mail.it");
        createEmployee("Donkey", "Kong", LocalDate.of(1996, 2, 29), "donkey.kong@mail.it");
        createEmployee("Bowser", "Koopa", LocalDate.of(1994, 2, 28), "bowser.koopa@mail.it");
        createEmployee("Peach", "ToadStool", LocalDate.of(1994, 12, 3), "peach.toadstool@mail.it");
        createEmployee("Daisy", "ToadStool", LocalDate.of(1994, 12, 3), "daisy.toadstool@mail.it");
        er = createEmployeeRepository();
        ems = createEmailService();
        bs = new BirthdayServiceImpl(er, ems);
    }

    @Test
    public void employeeTest(){
        bs.sendGreetings(12, 29);
        assertThat(bs.getEmployeesBornOn())
                .extracting("name", "surname")
                .contains(Tuple.tuple("Mario", "Bros"));
    }

    @Test
    public void employeeRepositoryTest(){
        assertThat(bs.getEmployeeRepository()).isEqualTo(er);
    }

    @Test
    public void emailServiceTest(){
        bs.sendGreetings(12, 3);
        //assertThat(bs.getEmailService().sendEmail("Daisy")).isEqualTo(ems.sendEmail("Daisy"));
        assertThat(bs.getEmailService().getEmailFrom()).isEqualTo(ems.getEmailFrom());
    }

    //2020 bisestile quindi in quest'anno vengono spediti il 29 febbraio...
    @Test
    public void leapYearOrNotTest() {
        bs.sendGreetings(2, 29);
        assertThat(bs.getEmployeesBornOn()).isNotNull();
    }


    private void createEmployee(String name, String surname, LocalDate birthday, String email){
        Employee emp = mock(EmployeeImpl.class);
        when(emp.getName()).thenReturn(name);
        when(emp.getSurname()).thenReturn(surname);
        when(emp.getBirthdayDate()).thenReturn(birthday);
        when(emp.getEmail()).thenReturn(email);
        listOfEmployees.add(emp);
    }

    private EmployeeRepositoryImpl createEmployeeRepository(){
        EmployeeRepositoryImpl empRep = mock(EmployeeRepositoryImpl.class);
        when(empRep.findEmployeesBornOn(12, 29)).thenReturn(listOfEmployees.subList(0,2));
        when(empRep.findEmployeesBornOn(12, 3)).thenReturn(listOfEmployees.subList(4,6));
        when(empRep.findEmployeesBornOn(2, 29)).thenReturn(LocalDate.now().isLeapYear() ? (listOfEmployees.subList(2,3)): null);
        when(empRep.findEmployeesBornOn(2, 28)).thenReturn(LocalDate.now().isLeapYear() ? listOfEmployees.subList(3,4) : listOfEmployees.subList(2,4));
        return empRep;
    }

    private EmailServiceImpl createEmailService(){
        EmailServiceImpl ems = mock(EmailServiceImpl.class);
        when(ems.getObject()).thenReturn("Happy Birthday!");
        when(ems.getText()).thenReturn("Happy Birthday, dear");
        return ems;

    }
}
