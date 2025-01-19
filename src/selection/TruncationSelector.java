package selection;

import gene.Individual;
import gene.encoding.Encoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TruncationSelector<T> implements Selector<T> {
  @Override
  public ArrayList<Individual<T>> select(ArrayList<Individual<T>> population, T desired) {
    for (Individual<T> individual : population) {
      individual.calculateFitness(desired);
    }
    Collections.sort(population);
    return new ArrayList<>(population.subList(population.size() / 2, population.size()));
  }
}
