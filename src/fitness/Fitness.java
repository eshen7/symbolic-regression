package fitness;

import gene.encoding.Encoding;

public interface Fitness<T> {
  double calculateFitness(Encoding encoding, T data);
}
