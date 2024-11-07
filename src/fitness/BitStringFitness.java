package fitness;

import gene.Individual;
import gene.encoding.Encoding;

public class BitStringFitness implements Fitness {
  @Override
  public double calculateFitness(Encoding encoding, String desired) {
    String data = encoding.getData();
    if (data.length() != desired.length()) {
      throw new IllegalArgumentException();
    }
    int sumSquaredError = 0;
    for (int i = 0; i < data.length(); i++) {
      int individualBit = Character.getNumericValue(data.charAt(i));
      int desiredBit = Character.getNumericValue(desired.charAt(i));
      sumSquaredError += (int) Math.pow(individualBit - desiredBit, 2);
    }
    return 1.0 * sumSquaredError / data.length();
  }
}
