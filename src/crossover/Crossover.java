package crossover;

import gene.Individual;

public interface Crossover {
  Individual[] doCrossover(Individual parent1, Individual parent2);
}
