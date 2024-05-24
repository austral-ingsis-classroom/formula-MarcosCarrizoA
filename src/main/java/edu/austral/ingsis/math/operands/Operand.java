package edu.austral.ingsis.math.operands;

public interface Operand {
  double evaluate(double left, double right);

  String getSymbol();
}
