package gene;

import fitness.Fitness;
import mutation.Mutation;

public class BitString extends Individual {
  public BitString(String encoding, Fitness fitnessFunction, Mutation mutationFunction, double mutationRate) {
    super(encoding, fitnessFunction, mutationFunction, mutationRate);
  }

  @Override
  public Individual copy() {
    return new BitString(this.encoding, this.fitnessFunction, this.mutationFunction, this.mutationRate);
  }
}
