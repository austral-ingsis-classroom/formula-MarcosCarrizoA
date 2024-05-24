package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.operands.Operand;
import edu.austral.ingsis.math.operands.SingleOperand;
import java.util.ArrayList;
import java.util.Map;

public class Operation implements MyExpression {
  private final MyExpression left;
  private final MyExpression right;
  private final Operand operand;
  private final SingleOperand singleOperand;

  public Operation(MyExpression left, MyExpression right, Operand operand) {
    this.left = left;
    this.right = right;
    this.operand = operand;
    this.singleOperand = null;
  }

  public Operation(MyExpression left, SingleOperand operand) {
    this.left = left;
    this.right = null;
    this.operand = null;
    this.singleOperand = operand;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    if (operand == null) {
      assert singleOperand != null;
      return singleOperand.evaluate(left.evaluate(variables));
    }
    assert right != null;
    return operand.evaluate(left.evaluate(variables), right.evaluate(variables));
  }

  @Override
  public String toString() {
    return nestedToString(false);
  }

  @Override
  public String nestedToString(boolean isNested) {
    String result;
    if (operand == null) {
      assert singleOperand != null;
      result = singleOperand.getSymbol().replace(" ", left.toString());
    } else {
      assert right != null;
      result =
          left.nestedToString(true) + " " + operand.getSymbol() + " " + right.nestedToString(true);
    }
    return isNested && singleOperand == null ? "(" + result + ")" : result;
  }

  @Override
  public ArrayList<String> getVariables() {
    ArrayList<String> vars = new ArrayList<>(left.getVariables());
    if (right != null) {
      vars.addAll(right.getVariables());
    }
    return vars;
  }
}
