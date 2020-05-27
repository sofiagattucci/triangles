import static org.mockito.Mockito.mock;

import it.unimi.kata.implementations.BirthdayServiceImpl;
import it.unimi.kata.interfaces.BirthdayService;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.EmployeeRepository;
import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    EmployeeRepository employeeRepository;
    employeeRepository = mock(EmployeeRepository.class);
    EmailService emailService = mock(EmailService.class);

    BirthdayService birthdayService = new BirthdayServiceImpl(employeeRepository, emailService);
    birthdayService.sendGreetings(LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
  }
}
