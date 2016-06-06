package parser;

class Source {

  public final String str;
  public int pos;

  public Source(String str) {
    this.str = str;
  }

  public final int peek() {
    if (pos < str.length()) {
      return str.charAt(pos);
    }
    return -1;
  }

  public final void next() {
    ++pos;
  }

}
