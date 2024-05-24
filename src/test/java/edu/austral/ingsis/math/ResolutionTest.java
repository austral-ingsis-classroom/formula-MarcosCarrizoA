package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.expression.MyNumber;
import edu.austral.ingsis.math.expression.Operation;
import edu.austral.ingsis.math.operands.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double myResult =
        new Operation(new MyNumber(1), new MyNumber(6), new Add()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double myResult =
        new Operation(new MyNumber(12), new MyNumber(2), new Div()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double myResult =
        new Operation(
                new Operation(new MyNumber(9), new MyNumber(2), new Div()),
                new MyNumber(3),
                new Mult())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double myResult =
        new Operation(
                new Operation(new MyNumber(27), new MyNumber(6), new Div()),
                new MyNumber(2),
                new Pow())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double myResult =
        new Operation(new MyNumber(36), new MyNumber(0.5), new Pow()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double myResult = new Operation(new MyNumber(136), new Abs()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double myResult = new Operation(new MyNumber(136), new Abs()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double myResult =
        new Operation(
                new Operation(new MyNumber(5), new MyNumber(5), new Sub()),
                new MyNumber(8),
                new Mult())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(0d));
  }
}
