package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.expression.MyExpression;
import edu.austral.ingsis.math.expression.MyNumber;
import edu.austral.ingsis.math.expression.MyVariable;
import edu.austral.ingsis.math.expression.Operation;
import edu.austral.ingsis.math.operands.*;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final MyExpression result = new Operation(new MyNumber(1), new MyNumber(6), new Add());

    assertThat(result.getVariables(), empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final MyExpression result = new Operation(new MyNumber(1), new MyVariable("div"), new Div());

    assertThat(result.getVariables(), containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final MyExpression result =
        new Operation(
            new Operation(new MyNumber(9), new MyVariable("x"), new Div()),
            new MyVariable("y"),
            new Mult());

    assertThat(result.getVariables(), containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final MyExpression result =
        new Operation(
            new Operation(new MyNumber(27), new MyVariable("a"), new Div()),
            new MyVariable("b"),
            new Pow());

    assertThat(result.getVariables(), containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final MyExpression result =
        new Operation(
            new MyVariable("z"),
            new Operation(new MyNumber(1), new MyNumber(2), new Div()),
            new Pow());

    assertThat(result.getVariables(), containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final MyExpression result =
        new Operation(
            new Operation(new MyVariable("value"), new Abs()), new MyNumber(8), new Sub());

    assertThat(result.getVariables(), containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final MyExpression result =
        new Operation(
            new Operation(new MyVariable("value"), new Abs()), new MyNumber(8), new Sub());

    assertThat(result.getVariables(), containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final MyExpression result =
        new Operation(
            new Operation(new MyNumber(5), new MyVariable("i"), new Sub()),
            new MyNumber(8),
            new Mult());

    assertThat(result.getVariables(), containsInAnyOrder("i"));
  }
}
