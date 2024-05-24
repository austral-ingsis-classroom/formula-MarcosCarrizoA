package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.Map;

class MyNumber implements MyExpression {
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
    return Double.toString(value);
  }

  @Override
  public ArrayList<String> getVariables() {
    return new ArrayList<>();
  }
}
