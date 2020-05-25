package it.unimi.di.vec.extensions;

import java.lang.annotation.Annotation;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MethodDescriptionExtension implements BeforeEachCallback {
  @Override
  public void beforeEach(ExtensionContext context) {
    System.out.println("It's executing " + context.getDisplayName());
    System.out.print("And it's annotate with: ");
    for (Annotation annotation : context.getRequiredTestMethod().getAnnotations()) {
      System.out.print(annotation.toString() + " ");
    }
    System.out.println(" ");
  }
}
