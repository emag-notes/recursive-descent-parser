package parser;

public class Parser extends Source {

  public Parser(String str) {
    super(str);
  }

  public final int number() {
    StringBuilder sb = new StringBuilder();
    int ch;
    while ((ch = peek()) >= 0 && Character.isDigit(ch)) {
      sb.append((char) ch);
      next();
    }
    return Integer.parseInt(sb.toString());
  }

  // expr = term, {("+", term) | ("-", term)}
  public final int expr() {
    int x = term();
    while (true) {
      switch (peek()) {
        case '+':
          next();
          x += term();
          continue;
        case '-':
          next();
          x -= term();
          continue;
      }
      break;
    }
    return x;
  }

  // term = factor, {("*", factor) | ("/", factor)}
  public final int term() {
    int x = factor();
    while (true) {
      switch (peek()) {
        case '*':
          next();
          x *= factor();
          continue;
        case '/':
          next();
          x /= factor();
          continue;
      }
      break;
    }
    return x;
  }

  // factor = ("(", expr, ")") | number
  public final int factor() {
    int ret;
    spaces();
    if (peek() == '(') {
      next();
      ret = expr();
      if (peek() == ')') {
        next();
      }
      return ret;
    } else {
      ret = number();
    }
    spaces();
    return ret;
  }

  public void spaces() {
    while (peek() == ' ') {
      next();
    }
  }

}
