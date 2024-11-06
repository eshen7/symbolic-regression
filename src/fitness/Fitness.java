package fitness;

import gene.Individual;

public interface Fitness {
  double calculateFitness(Individual individual, String desired);
}
