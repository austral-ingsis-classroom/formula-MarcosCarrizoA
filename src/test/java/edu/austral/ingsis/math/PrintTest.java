package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.expression.MyNumber;
import edu.austral.ingsis.math.expression.MyVariable;
import edu.austral.ingsis.math.expression.Operation;
import edu.austral.ingsis.math.operands.*;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final String result = new Operation(new MyNumber(1), new MyNumber(6), new Add()).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final String result = new Operation(new MyNumber(12), new MyNumber(2), new Div()).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final String result =
        new Operation(
                new Operation(new MyNumber(9), new MyNumber(2), new Div()),
                new MyNumber(3),
                new Mult())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final String result =
        new Operation(
                new Operation(new MyNumber(27), new MyNumber(6), new Div()),
                new MyNumber(2),
                new Pow())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result =
        new Operation(new Operation(new MyVariable("value"), new Abs()), new MyNumber(8), new Sub())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final String result =
        new Operation(new Operation(new MyVariable("value"), new Abs()), new MyNumber(8), new Sub())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final String result =
        new Operation(
                new Operation(new MyNumber(5), new MyVariable("i"), new Sub()),
                new MyNumber(8),
                new Mult())
            .toString();

    assertThat(result, equalTo(expected));
  }
}
