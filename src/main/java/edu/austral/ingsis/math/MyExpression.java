package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.Map;

interface MyExpression {
  double evaluate(Map<String, Double> variables);

  String toString();

  ArrayList<String> getVariables();
}
