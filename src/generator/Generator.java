package generator;

import gene.Individual;
import gene.encoding.Encoding;

public interface Generator {
  public Encoding generate(int length);
}
