package generator;

import gene.encoding.Encoding;

public interface Generator {
  Encoding generate(int length);
}
