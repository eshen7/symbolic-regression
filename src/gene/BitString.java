package gene;

import fitness.Fitness;
import gene.encoding.Encoding;

public class BitString extends Individual {
  public BitString(Encoding encoding, Fitness fitnessFunction, double mutationRate) {
    super(encoding, fitnessFunction, mutationRate);
  }

  @Override
  public Individual copy() {
    return new BitString(this.encoding, this.fitnessFunction, this.mutationRate);
  }
}
