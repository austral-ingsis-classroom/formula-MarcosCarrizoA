package edu.austral.ingsis.math.operands;

public class Abs implements SingleOperand {
  @Override
  public double evaluate(double value) {
    return Math.abs(value);
  }

  @Override
  public String getSymbol() {
    return "| |";
  }
}
