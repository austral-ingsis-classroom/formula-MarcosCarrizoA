package edu.austral.ingsis.math.expression;

import java.util.ArrayList;
import java.util.Map;

public class MyVariable implements MyExpression {
  private final String name;

  public MyVariable(String name) {
    this.name = name;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return variables.get(name);
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public String nestedToString(boolean nested) {
    return name;
  }

  @Override
  public ArrayList<String> getVariables() {
    ArrayList<String> vars = new ArrayList<>();
    vars.add(name);
    return vars;
  }
}
