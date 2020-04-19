package it.unimi.kata.implementations;

import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;

import java.util.ArrayList;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    List<Employee> employees;
    List<Employee>  employeesBornOn;

    public EmployeeRepositoryImpl(){
        employeesBornOn = new ArrayList<>();
        employees = new ArrayList<>();
    }

    @Override
    public List<Employee> findEmployeesBornOn(int month, int day) {
        return employeesBornOn;
    }
}
