package edu.austral.ingsis.math.operands;

public class Add implements Operand {
  @Override
  public double evaluate(double left, double right) {
    return left + right;
  }

  @Override
  public String getSymbol() {
    return "+";
  }
}
