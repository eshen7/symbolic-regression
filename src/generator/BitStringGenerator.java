package generator;

import gene.Individual;
import gene.encoding.BitStringEncoding;
import gene.encoding.Encoding;
import generator.Generator;

import java.util.Random;

public class BitStringGenerator implements Generator {
  Random rand = new Random();
  @Override
  public Encoding generate(int length) {

    StringBuilder bitString = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
      bitString.append(rand.nextBoolean() ? '1' : '0');
    }

    return new BitStringEncoding(bitString.toString());
  }
}
