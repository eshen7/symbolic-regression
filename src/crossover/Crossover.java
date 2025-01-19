package crossover;

import gene.Individual;

public interface Crossover<T> {
  Individual<T>[] doCrossover(Individual<T> parent1, Individual<T> parent2);
}
