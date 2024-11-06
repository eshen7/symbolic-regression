package mutation;

import gene.BitString;
import gene.Individual;

import java.util.Random;

public class BitStringMutate implements Mutation {
  Random rand = new Random();
  @Override
  public void mutate(Individual individual) {
    if (!(individual instanceof BitString)) {
      throw new IllegalArgumentException();
    }
    String encoding = individual.getEncoding();
    int flipBit = rand.nextInt(encoding.length());
    int newBit = Character.getNumericValue(encoding.charAt(flipBit)) == 0 ? 1 : 0;
    individual.setEncoding(encoding.substring(0, flipBit) + newBit + encoding.substring(flipBit + 1));
  }
}
