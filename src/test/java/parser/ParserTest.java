package parser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

  @Test
  public void test_12_plus_34_plus_56() throws Exception {
    int result = new Parser("12+34+56").expr();
    assertThat(result).isEqualTo(102);
  }

  @Test
  public void test_1_minus_2_minus_3() throws Exception {
    int result = new Parser("1-2-3").expr();
    assertThat(result).isEqualTo(-4);
  }

  @Test
  public void test_1_minus_2_plus_3() throws Exception {
    int result = new Parser("1-2+3").expr();
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void test_2_multi_3_plus_4() throws Exception {
    int result = new Parser("2*3+4").expr();
    assertThat(result).isEqualTo(10);
  }

  @Test
  public void test_2_plus_3_multi_4() throws Exception {
    int result = new Parser("2+3*4").expr();
    assertThat(result).isEqualTo(14);
  }

  @Test
  public void test_100_divide_10_divide_2() throws Exception {
    int result = new Parser("100/10/2").expr();
    assertThat(result).isEqualTo(5);
  }

  @Test
  public void test_factor2_plus_3factor_multi_4() throws Exception {
    int result = new Parser("(2+3)*4").expr();
    assertThat(result).isEqualTo(20);
  }

  @Test
  public void test_1__plus__2() throws Exception {
    int result = new Parser("1 + 2").expr();
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void test_123() throws Exception {
    int result = new Parser("123").expr();
    assertThat(result).isEqualTo(123);
  }

}