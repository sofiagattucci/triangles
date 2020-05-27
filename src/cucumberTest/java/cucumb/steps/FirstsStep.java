package cucumb.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import it.unimi.kata.implementations.EmployeeRepositoryImpl;
import it.unimi.kata.interfaces.Employee;
import it.unimi.kata.interfaces.EmployeeRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstsStep {

    int month;
    int dayOfMonth;
    EmployeeRepository empRep;
    List<Employee> empBornOn;

    @Given("i seguenti impiegati")
    public void i_seguenti_impiegati(String docString) throws IOException {
        FileWriter myWriter = new FileWriter("filename.txt");
        myWriter.write(docString);
        myWriter.close();
        empRep = new EmployeeRepositoryImpl("filename.txt");
    }

    @Given("oggi è il giorno {dateToSent}")
    public void oggi_è_il_giorno(LocalDate localDate) {
        month = localDate.getMonthValue();
        dayOfMonth = localDate.getDayOfMonth();
    }

    @ParameterType("(\\d+)-(\\d+)-(\\d+)")
    public LocalDate dateToSent(String y, String m, String d){
        return LocalDate.of(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));
    }

    @When("chiedo a chi devo mandare la mail")
    public void chiedo_a_chi_devo_mandare_la_mail() {
        empBornOn = empRep.findEmployeesBornOn(month, dayOfMonth);
    }

    @Then("ottengo la seguente lista:")
    public void ottengo_la_seguente_lista(List<List<String>> dataTable) {
        assertThat(dataTable.size()).isEqualTo(2);
    }

}
