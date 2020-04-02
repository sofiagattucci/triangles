package it.unimi.di.vec.extensions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;

@ExtendWith(SystemIOExtension.class)
public class TestSystemIOExtension {


    @ParameterizedTest
    @ValueSource(strings = {
            "first output",
            "second output",
            "third output"
    })
    public void testOutput(String value, ByteArrayOutputStream systemOutput){
        System.out.print(value);
        assertThat(value).isEqualTo(systemOutput.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "first input",
            "second input",
            "third input"
    })
    public void testInput(String value, InputStream systemInput) {
        systemInput = new ByteArrayInputStream(value.getBytes());
        System.setIn(systemInput);
        Scanner catchInput = new Scanner(System.in);
        assertThat(value).isEqualTo(catchInput.nextLine());
    }

}
