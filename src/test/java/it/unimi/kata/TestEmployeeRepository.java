package it.unimi.kata;

import it.unimi.kata.implementations.EmployeeRepositoryImpl;
import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.mock;

@Tag("slow")
public class TestEmployeeRepository {

    EmployeeRepository empRep;

    @BeforeEach
    public void setUp() throws IOException {
        empRep = new EmployeeRepositoryImpl("repo.txt");
    }

    @Test
    public void containEmployeeWithBirthdayDate(){
        List<Employee> empBornOn = empRep.findEmployeesBornOn(12, 03);
        assertThat(empBornOn).isNotNull();
    }

    @Test
    public void nameTest(){
        List<Employee> empBornOn = empRep.findEmployeesBornOn(12, 29);
        assertThat(empBornOn.toArray())
                .extracting("name")
                .contains(tuple("Mario", "Luigi")
                        .toArray());
    }
}
