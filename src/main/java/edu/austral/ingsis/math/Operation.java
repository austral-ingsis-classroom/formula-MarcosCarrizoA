package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.Map;

class Operation implements MyExpression {
  private final MyExpression left;
  private final MyExpression right;
  private final Operand operand;

  public Operation(MyExpression left, MyExpression right, Operand operand) {
    System.out.println("siii");
    this.left = left;
    this.right = right;
    this.operand = operand;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return operand.evaluate(left.evaluate(variables), right.evaluate(variables));
  }

  @Override
  public String toString() {
    return "(" + left.toString() + " " + operand.getSymbol() + " " + right.toString() + ")";
  }

  @Override
  public ArrayList<String> getVariables() {
    ArrayList<String> vars = new ArrayList<>(left.getVariables());
    vars.addAll(right.getVariables());
    return vars;
  }
}
