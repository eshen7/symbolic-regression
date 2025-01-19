package util;

import gene.encoding.Encoding;

public abstract class Node implements Encoding {
  public abstract double evaluate(double x);
  public abstract Node copy();
}
