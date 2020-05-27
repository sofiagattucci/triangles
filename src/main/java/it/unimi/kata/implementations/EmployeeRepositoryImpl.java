package it.unimi.kata.implementations;

import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  List<Employee> employees;
  List<Employee> employeesBornOn;
  String fileRepoPath;

  public EmployeeRepositoryImpl(String fileRepoPath) throws IOException {
    this.fileRepoPath = fileRepoPath;
    employeesBornOn = new ArrayList<>();
    employees = new ArrayList<>();
    readEmployeeFromFile();
  }

  void readEmployeeFromFile() throws IOException {
    ClassLoader cs = getClass().getClassLoader();
    Reader is = new InputStreamReader(Objects.requireNonNull(cs.getResourceAsStream("repo.txt")));
    BufferedReader br = new BufferedReader(is);
    for (String line = br.readLine(); line != null; line = br.readLine()) {
      String[] splitted = line.replaceAll(" ", "").split(",");
      LocalDate dateToInsert = LocalDate.parse(splitted[2].replace("/", "-"));
      employees.add(new EmployeeImpl(splitted[0], splitted[1], dateToInsert, splitted[3]));
    }
  }

  @Override
  public List<Employee> findEmployeesBornOn(int month, int day) {
    for (Employee e : employees) {
      if (e.getBirthdayDate().getMonthValue() == month
          && e.getBirthdayDate().getDayOfMonth() == day) {
        employeesBornOn.add(e);
      }
    }
    return employeesBornOn;
  }
}
