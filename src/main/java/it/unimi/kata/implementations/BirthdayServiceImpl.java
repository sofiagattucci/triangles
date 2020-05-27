package it.unimi.kata.implementations;

import it.unimi.kata.interfaces.BirthdayService;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;
import java.time.LocalDate;
import java.util.List;

public class BirthdayServiceImpl implements BirthdayService {

  public List<Employee> getEmployeesBornOn() {
    return employeesBornOn;
  }

  public EmployeeRepository getEmployeeRepository() {
    return employeeRepository;
  }

  public EmailService getEmailService() {
    return emailService;
  }

  List<Employee> employeesBornOn;
  EmployeeRepository employeeRepository;
  EmailService emailService;
  String object = "Happy Birthday!";
  String text = "Happy Birthday, dear ";

  public BirthdayServiceImpl(EmployeeRepository er, EmailService es) {
    employeeRepository = er;
    emailService = es;
  }

  @Override
  public void sendGreetings(int month, int day) {
    employeesBornOn = employeeRepository.findEmployeesBornOn(month, day);
    if (!LocalDate.now().isLeapYear()) {
      employeesBornOn.addAll(employeeRepository.findEmployeesBornOn(2, 29));
    }
    for (Employee emp : employeesBornOn)
      emailService.sendEmail(emp.getEmail(), object, text + emp.getName() + "!");
  }
}
