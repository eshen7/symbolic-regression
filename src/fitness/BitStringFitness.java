package fitness;

import gene.encoding.Encoding;

public class BitStringFitness implements Fitness<Encoding> {

  @Override
  public double calculateFitness(Encoding encoding, Encoding desired) {
    String data = encoding.getData();
    if (data.length() != desired.getData().length()) {
      throw new IllegalArgumentException();
    }
    int sumSquaredError = 0;
    for (int i = 0; i < data.length(); i++) {
      int individualBit = Character.getNumericValue(data.charAt(i));
      int desiredBit = Character.getNumericValue(desired.getData().charAt(i));
      sumSquaredError += (int) Math.pow(individualBit - desiredBit, 2);
    }
    return 1 - 1.0 * sumSquaredError / data.length();
  }
}
