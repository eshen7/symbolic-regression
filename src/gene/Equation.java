package gene;

import fitness.Fitness;
import gene.encoding.Encoding;
import util.Node;

import java.util.List;

public class Equation extends Individual<List<double[]>> {
  public Equation(Encoding encoding, Fitness<List<double[]>> fitnessFunction, double mutationRate) {
    super(encoding, fitnessFunction, mutationRate);
  }

  @Override
  public Individual<List<double[]>> copy() {
    return new Equation(((Node) this.encoding).copy(), this.fitnessFunction, this.mutationRate);
  }
}
