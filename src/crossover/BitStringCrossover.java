package crossover;

import gene.BitString;
import gene.Individual;
import gene.encoding.BitStringEncoding;
import gene.encoding.Encoding;

import java.util.Random;

public class BitStringCrossover implements Crossover<Encoding> {
  Random rand = new Random();

  @Override
  public Individual<Encoding>[] doCrossover(Individual<Encoding> parent1, Individual<Encoding> parent2) {
    if (!(parent1 instanceof BitString) && !(parent2 instanceof BitString)) {
      throw new IllegalArgumentException();
    }
    Encoding encoding1 = parent1.getEncoding();
    Encoding encoding2 = parent2.getEncoding();
    if (encoding1.getData().length() != encoding2.getData().length()) {
      throw new IllegalArgumentException();
    }
    int crossover = rand.nextInt(encoding1.getData().length());
    String childEncoding1 = encoding1.getData().substring(0, crossover) + encoding2.getData().substring(crossover);
    String childEncoding2 = encoding2.getData().substring(0, crossover) + encoding1.getData().substring(crossover);
    Individual<Encoding> child1 = parent1.copy();
    Individual<Encoding> child2 = parent2.copy();
    child1.setEncoding(new BitStringEncoding(childEncoding1));
    child2.setEncoding(new BitStringEncoding(childEncoding2));
    return (Individual<Encoding>[]) new Individual[]{child1, child2};
  }
}
