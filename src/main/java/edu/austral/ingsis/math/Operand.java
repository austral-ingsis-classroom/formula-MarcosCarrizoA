package edu.austral.ingsis.math;

public interface Operand {
  double evaluate(double left, double right);

  String getSymbol();
}
