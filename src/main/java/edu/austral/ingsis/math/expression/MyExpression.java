package edu.austral.ingsis.math.expression;

import java.util.ArrayList;
import java.util.Map;

public interface MyExpression {
  double evaluate(Map<String, Double> variables);

  String toString();

  String nestedToString(boolean nested);

  ArrayList<String> getVariables();
}
