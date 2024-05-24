package edu.austral.ingsis.math.operands;

public class Pow implements Operand {
  @Override
  public double evaluate(double left, double right) {
    return Math.pow(left, right);
  }

  @Override
  public String getSymbol() {
    return "^";
  }
}
