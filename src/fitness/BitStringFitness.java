package fitness;

import gene.Individual;

public class BitStringFitness implements Fitness {
  @Override
  public double calculateFitness(Individual individual, String desired) {
    String encoding = individual.getEncoding();
    if (encoding.length() != desired.length()) {
      throw new IllegalArgumentException();
    }
    int sumSquaredError = 0;
    for (int i = 0; i < encoding.length(); i++) {
      int individualBit = Character.getNumericValue(encoding.charAt(i));
      int desiredBit = Character.getNumericValue(desired.charAt(i));
      sumSquaredError += (int) Math.pow(individualBit - desiredBit, 2);
    }
    return 1.0 * sumSquaredError / encoding.length();
  }
}
