package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.expression.MyNumber;
import edu.austral.ingsis.math.expression.MyVariable;
import edu.austral.ingsis.math.expression.Operation;
import edu.austral.ingsis.math.operands.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result =
        new Operation(new MyNumber(1), new MyVariable("x"), new Add()).evaluate(Map.of("x", 3d));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result =
        new Operation(new MyNumber(12), new MyVariable("div"), new Div())
            .evaluate(Map.of("div", 4d));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result =
        new Operation(
                new Operation(new MyNumber(9), new MyVariable("x"), new Div()),
                new MyVariable("y"),
                new Mult())
            .evaluate(Map.of("x", 3d, "y", 4d));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result =
        new Operation(
                new Operation(new MyNumber(27), new MyVariable("a"), new Div()),
                new MyVariable("b"),
                new Pow())
            .evaluate(Map.of("a", 9d, "b", 3d));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result =
        new Operation(new MyVariable("z"), new MyNumber(0.5), new Pow()).evaluate(Map.of("z", 36d));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result =
        new Operation(
                new Operation(new MyVariable("value"), new Abs()),
                new MyNumber(8),
                new edu.austral.ingsis.math.operands.Sub())
            .evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result =
        new Operation(
                new Operation(new MyVariable("value"), new Abs()),
                new MyNumber(8),
                new edu.austral.ingsis.math.operands.Sub())
            .evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result =
        new Operation(
                new Operation(new MyNumber(5), new MyVariable("i"), new Sub()),
                new MyNumber(8),
                new Mult())
            .evaluate(Map.of("i", 2d));

    assertThat(result, equalTo(24d));
  }
}
