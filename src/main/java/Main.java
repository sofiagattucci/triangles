import com.google.inject.Guice;
import it.unimi.kata.implementations.BDSModule;
import it.unimi.kata.implementations.BirthdayServiceImpl;
import it.unimi.kata.interfaces.BirthdayService;
import it.unimi.kata.interfaces.EmailService;
import it.unimi.kata.interfaces.EmployeeRepository;
import javafx.util.Pair;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

import static org.mockito.Mockito.mock;


public class Main{

    public static void main(String[] args) throws IOException {
//        BirthdayService birthdayService = Guice.createInjector(new BDSModule()).getInstance(BirthdayServiceImpl.class);

//        birthdayService.sendGreetings(LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }
}
