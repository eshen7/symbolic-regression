package gene.encoding;

import java.util.Random;

public class BitStringEncoding implements Encoding {
  private String encoding;
  Random rand = new Random();

  public BitStringEncoding(String encoding) {
    this.encoding = encoding;
  }

  @Override
  public String getData() {
    return encoding;
  }

  @Override
  public void mutate(double mutationRate) {
    if (rand.nextDouble() < mutationRate) {
      return;
    }
    String bits = this.encoding;
    int flipBit = rand.nextInt(bits.length());
    int newBit = Character.getNumericValue(bits.charAt(flipBit)) == 0 ? 1 : 0;
    this.encoding = bits.substring(0, flipBit) + newBit + bits.substring(flipBit + 1);
  }
}
