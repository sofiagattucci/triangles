package it.unimi.kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.*;

import it.unimi.kata.implementations.EmployeeImpl;
import it.unimi.kata.interfaces.Employee;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestEmployee {

  Employee employee1;
  Employee employee2;
  Employee employee3;
  Employee employee4;
  List<Employee> listOfEmployees;

  @BeforeEach
  public void setUp() {
    listOfEmployees = new ArrayList<>();
    employee1 = setUpEmployee("Mario", "Bros", LocalDate.of(1996, 12, 29), "mario.bros@mail.it");
    employee2 = setUpEmployee("Luigi", "Bros", LocalDate.of(1996, 12, 29), "luigi.bros@mail.it");
    employee3 =
        setUpEmployee("Peach", "Toadstool", LocalDate.of(1996, 12, 29), "peach.toadstool@mail.it");
    employee4 =
        setUpEmployee("Daisy", "Toadstool", LocalDate.of(1996, 12, 29), "daisy.toadstool@mail.it");
  }

  @Test
  public void simpleEmployeeTest() {
    assertThat(employee1)
        .extracting("name", "surname", "birthdayDate", "email")
        .contains(
            tuple("Mario", "Bros", LocalDate.of(1996, 12, 29), "mario.bros@mail.it").toArray());
  }

  @ParameterizedTest
  @ValueSource(strings = {"Mario", "Luigi", "Peach", "Daisy"})
  public void nameTest(String name) {
    assertThat(listOfEmployees).extracting("name").contains(name);
  }

  private Employee setUpEmployee(String name, String surname, LocalDate birthday, String email) {
    Employee emp = new EmployeeImpl(name, surname, birthday, email);
    listOfEmployees.add(emp);
    return emp;
  }
}
