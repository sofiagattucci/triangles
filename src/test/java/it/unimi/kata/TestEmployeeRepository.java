package it.unimi.kata;

import it.unimi.kata.implementations.EmployeeImpl;
import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestEmployeeRepository {

    EmployeeRepository empRepMocked;

    @BeforeEach
    public void setUp(){
        List<Employee> employees = createEmployees();
        empRepMocked = mock(EmployeeRepository.class);
        when(empRepMocked.findEmployeesBornOn(12, 29)).thenReturn(employees.subList(0,2));
        when(empRepMocked.findEmployeesBornOn(12, 3)).thenReturn(employees.subList(2,4));
    }

    @Test
    public void containEmployeeWithBirthdayDate(){
        List<Employee> empBornOn = empRepMocked.findEmployeesBornOn(12, 3);
        assertThat(empBornOn).isNotNull();
    }

    @Test
    public void nameTest(){
        List<Employee> empBornOn = empRepMocked.findEmployeesBornOn(12, 29);
        assertThat(empBornOn.toArray()).extracting("name").contains(tuple("Mario", "Luigi").toArray());
    }

    private List<Employee> createEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeImpl("Mario", "Bros", LocalDate.of(1996, 12, 29), "mario.bros@mail.it"));
        employees.add(new EmployeeImpl("Luigi", "Bros", LocalDate.of(1996, 12, 29), "luigi.bros@mail.it"));
        employees.add(new EmployeeImpl("Peach", "ToadStool", LocalDate.of(1994, 12, 3), "peach.toadstool@mail.it"));
        employees.add(new EmployeeImpl("Daisy", "ToadStool", LocalDate.of(1994, 12, 3), "daisy.toadstool@mail.it"));
        return employees;
    }
}
