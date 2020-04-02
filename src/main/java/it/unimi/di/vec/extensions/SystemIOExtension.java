package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.extension.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemIOExtension implements ParameterResolver, InvocationInterceptor {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    InputStream is;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == ByteArrayOutputStream.class || parameterContext.getParameter().getType() == InputStream.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        configureOutput(outputStream);
        System.setIn(is);
        return parameterContext.getParameter().getType() == ByteArrayOutputStream.class ? outputStream : is;
    }

    private void configureOutput(ByteArrayOutputStream outputStream) {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }
}