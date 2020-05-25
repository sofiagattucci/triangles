package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MethodDescriptionExtension.class)
public class TestMethodDescription {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream backup = System.out;

    @BeforeEach
    public void initialConfiguration() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void notNullTest(){
        assertThat(outputStream).isNotNull();
    }

//  la scrittura della descrizione tramite estensione, seppur fatta su StdOut, non viene catturata perché fatta nel beforeEach
    @Test
    public void simpleTest(){
        System.out.print("ciaoooo");
        assertThat(outputStream).asString().contains("ciao");
    }

    @AfterEach
    void restore(){
        System.setOut(backup);
    }

}
