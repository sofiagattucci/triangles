package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;


public class TestSystemOutputExtension {

    @Test
    @ExtendWith(SystemOutputExtension.class)
    public void testOutputSimple(ByteArrayOutputStream systemOutput) {
        System.out.print("output");
        assertThat(systemOutput.toString()).isEqualTo("output");
    }

    @Test
    @SystemOutLog
    public void testOutputAnnotation(ByteArrayOutputStream systemOutput) {
        System.out.print("output");
        assertThat(systemOutput.toString()).isEqualTo("output");
    }

    @ParameterizedTest
    @ExtendWith(SystemOutputExtension.class)
    @ValueSource(strings = {
            "first output",
            "second output",
            "third output"
    })
    public void testOutputParameterized(String value, ByteArrayOutputStream systemOutput){
        System.out.print(value);
        assertThat(systemOutput.toString()).isEqualTo(value);
    }

    @ParameterizedTest
    @SystemOutLog
    @ValueSource(strings = {
            "first output",
            "second output",
            "third output"
    })
    public void testOutputAnnotationParametrized(String value, ByteArrayOutputStream systemOutput){
        System.out.print(value);
        assertThat(systemOutput.toString()).isEqualTo(value);

    }

}
