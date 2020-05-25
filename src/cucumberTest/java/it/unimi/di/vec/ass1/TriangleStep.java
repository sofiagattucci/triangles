package it.unimi.di.vec.ass1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleStep {

    Triangle t;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream output = new PrintStream(outputStream);

    @Given("un triangolo con lati (.*?)$")
    public void un_triangolo_con_lati(String sides) {
        InputStream is = new ByteArrayInputStream(sides.getBytes());
        System.setIn(is);
        System.setOut(output);
        t = new TriangleImpl();
    }

    @When("chiedo che tipo di triangolo è")
    public void chiedo_che_tipo_di_triangolo_è() {
        t.describe();
    }

    @Then("ottengo {word}")
    public void ottengo_isoscele(String toCheck) {
        assertThat(outputStream.toString()).isEqualTo(toCheck);
    }


}
