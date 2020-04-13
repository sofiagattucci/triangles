package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.extension.*;

import java.io.*;

public class SystemInputExtension implements ParameterResolver, BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws IOException {
        ExtensionContext.Store s = context.getStore(ExtensionContext.Namespace.create(getClass(), context));
        s.put("origIn", System.in);

        WriteOnStdIn wosi = new WriteOnStdIn();
        s.put("in", wosi);
        checkAnnotation(context, wosi);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == WriteOnStdIn.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store s = extensionContext.getStore(ExtensionContext.Namespace.create(getClass(), extensionContext));
        return s.get("in", WriteOnStdIn.class);
    }

    private void checkAnnotation(ExtensionContext context, WriteOnStdIn wosi) throws IOException {
        String annotationValue = context.getRequiredTestMethod().getAnnotation(SystemInLog.class).value();
        if(!annotationValue.isEmpty())
            wosi.writeInput(annotationValue);
    }

    @Override
    public void afterEach(ExtensionContext context){
        ExtensionContext.Store s = context.getStore(ExtensionContext.Namespace.create(getClass(), context));
        InputStream in = s.remove("origIn", InputStream.class);
        s.remove("in");

        if (in != null) System.setIn(in);
    }

    public static class WriteOnStdIn {
        private final PipedOutputStream bos = new PipedOutputStream();

        private WriteOnStdIn() throws IOException {
            System.setIn(new PipedInputStream(bos));
        }

        public void writeInput(String ... values) throws IOException {
            for (String value : values) {
                bos.write(value.getBytes());
                bos.write("\n".getBytes());
            }
        }
    }
}