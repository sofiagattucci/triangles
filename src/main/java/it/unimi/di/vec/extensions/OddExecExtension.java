package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class OddExecExtension implements ExecutionCondition {

  private boolean odd = true;

  private ConditionEvaluationResult nextDecision() {
    odd = !odd;
    return odd
        ? ConditionEvaluationResult.disabled("Even")
        : ConditionEvaluationResult.enabled("Odd");
  }

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    return isMethodInstance(context)
        ? nextDecision()
        : ConditionEvaluationResult.enabled("Not Test Instance");
  }

  private boolean isMethodInstance(ExtensionContext context) {
    return context.getTestInstance().isPresent();
  }
}
