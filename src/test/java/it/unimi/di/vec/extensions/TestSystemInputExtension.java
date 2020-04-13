package it.unimi.di.vec.extensions;
import static it.unimi.di.vec.extensions.SystemInputExtension.WriteOnStdIn;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class TestSystemInputExtension {
    private BufferedReader br;

    @BeforeEach
    public void setUpInput(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Test
    @SystemInLog("ciao")
    public void testInputAnnotation() throws IOException {
        assertThat(br.readLine()).isEqualTo("ciao");
    }

    @Test
    @SystemInLog
    public void testInputInjection(WriteOnStdIn systemInput) throws IOException {
        systemInput.writeInput("ciao2");
        assertThat(br.readLine()).isEqualTo("ciao2");
    }

    @ParameterizedTest
    @SystemInLog
    @ValueSource(strings = {
            "first input",
            "second input",
            "third input"
    })
    public void testInput(String value, WriteOnStdIn systemInput) throws IOException {
        systemInput.writeInput(value);
        Scanner catchInput = new Scanner(System.in);
        assertThat(value).isEqualTo(catchInput.nextLine());
    }

    @AfterEach
    public void restoreInput(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }


}
