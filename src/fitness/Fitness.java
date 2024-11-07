package fitness;

import gene.Individual;
import gene.encoding.Encoding;

public interface Fitness {
  double calculateFitness(Encoding encoding, String desired);
}
