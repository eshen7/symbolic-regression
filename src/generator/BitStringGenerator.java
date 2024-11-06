package generator;

import gene.Individual;
import generator.Generator;

import java.util.Random;

public class BitStringGenerator implements Generator {
  Random rand = new Random();
  @Override
  public String generate(int length) {

    StringBuilder bitString = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
      // Append '0' or '1' randomly
      bitString.append(rand.nextBoolean() ? '1' : '0');
    }

    return bitString.toString();
  }
}
