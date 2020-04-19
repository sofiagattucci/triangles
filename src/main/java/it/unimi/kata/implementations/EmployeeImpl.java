package it.unimi.kata.implementations;

import it.unimi.kata.interfaces.Employee;

import java.time.LocalDate;
import java.util.Calendar;

public class EmployeeImpl implements Employee {

    String name;
    String surname;
    LocalDate birthdayDate;
    String email;

    public EmployeeImpl(String name, String surname, LocalDate birthday, String email) {
        this.name = name;
        this.surname = surname;
        this.birthdayDate = birthday;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
