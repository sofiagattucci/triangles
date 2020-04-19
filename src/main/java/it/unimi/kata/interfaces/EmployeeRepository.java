package it.unimi.kata.interfaces;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findEmployeesBornOn(int month, int day);
}
