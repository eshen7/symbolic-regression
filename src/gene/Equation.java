package gene;

import fitness.Fitness;
import gene.encoding.Encoding;

public class Equation extends Individual {
  public Equation(Encoding encoding, Fitness fitnessFunction, double mutationRate) {
    super(encoding, fitnessFunction, mutationRate);
  }

  @Override
  public Individual copy() {
    return new Equation(this.encoding, this.fitnessFunction, this.mutationRate);
  }
}
