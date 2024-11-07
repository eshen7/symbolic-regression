package fitness;

import gene.encoding.Encoding;

public interface Fitness {
  double calculateFitness(Encoding encoding, String desired);
}
