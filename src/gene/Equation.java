package gene;

import fitness.Fitness;
import mutation.Mutation;

public class Equation extends Individual {
  public Equation(String encoding, Fitness fitnessFunction, Mutation mutationFunction, double mutationRate) {
    super(encoding, fitnessFunction, mutationFunction, mutationRate);
  }

  @Override
  public Individual copy() {
    return new Equation(this.encoding, this.fitnessFunction, this.mutationFunction, this.mutationRate);
  }
}
