import java.lang.annotation.Annotation;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MethodDescriptionExt implements BeforeEachCallback {
  @Override
  public void beforeEach(ExtensionContext context) {
    System.err.println("It's executing " + context.getDisplayName());
    System.err.print("And it's annotate with:");
    for (Annotation annotation : context.getRequiredTestMethod().getAnnotations()) {
      System.err.print(annotation.toString() + " ");
    }
    System.err.println(" ");
  }
}
