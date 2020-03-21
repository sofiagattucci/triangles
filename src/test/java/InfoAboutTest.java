import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;
import java.util.Collection;

public class InfoAboutTest implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() {
                String testName = description.getMethodName();
                Collection<Annotation> annotation = description.getAnnotations();
                System.out.println(testName);
                annotation.forEach(System.out::println);
            }
        };
    }
}
