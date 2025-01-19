package gene;

import fitness.Fitness;
import gene.encoding.Encoding;

public class BitString extends Individual<Encoding> {
  public BitString(Encoding encoding, Fitness<Encoding> fitnessFunction, double mutationRate) {
    super(encoding, fitnessFunction, mutationRate);
  }

  @Override
  public Individual<Encoding> copy() {
    return new BitString(this.encoding, this.fitnessFunction, this.mutationRate);
  }
}
