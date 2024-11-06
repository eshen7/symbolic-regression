package crossover;

import gene.BitString;
import gene.Individual;

import java.util.Random;

public class BitStringCrossover implements Crossover {
  Random rand = new Random();

  @Override
  public Individual[] doCrossover(Individual parent1, Individual parent2) {
    if (!(parent1 instanceof BitString) && !(parent2 instanceof BitString)) {
      throw new IllegalArgumentException();
    }
    String encoding1 = parent1.getEncoding();
    String encoding2 = parent2.getEncoding();
    if (encoding1.length() != encoding2.length()) {
      throw new IllegalArgumentException();
    }
    int crossover = rand.nextInt(encoding1.length());
    String childEncoding1 = encoding1.substring(0, crossover) + encoding2.substring(crossover);
    String childEncoding2 = encoding2.substring(0, crossover) + encoding1.substring(crossover);
    Individual child1 = parent1.copy();
    Individual child2 = parent2.copy();
    child1.setEncoding(childEncoding1);
    child2.setEncoding(childEncoding2);
    return new Individual[] {child1, child2};
  }
}
