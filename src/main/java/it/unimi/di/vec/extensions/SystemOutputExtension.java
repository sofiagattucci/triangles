package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.extension.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutputExtension implements ParameterResolver, AfterEachCallback {

   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == ByteArrayOutputStream.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    @Override
    public void afterEach(ExtensionContext context) {
        outputStream.reset();
    }
}