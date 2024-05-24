package edu.austral.ingsis.math.expression;

import java.util.ArrayList;
import java.util.Map;

public class MyNumber implements MyExpression {
  private final double value;

  public MyNumber(double value) {
    this.value = value;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return value;
  }

  @Override
  public String toString() {
    return Integer.toString((int) value);
  }

  @Override
  public String nestedToString(boolean nested) {
    return Integer.toString((int) value);
  }

  @Override
  public ArrayList<String> getVariables() {
    return new ArrayList<>();
  }
}
