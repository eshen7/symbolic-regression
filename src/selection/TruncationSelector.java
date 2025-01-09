package selection;

import gene.Individual;
import gene.encoding.Encoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TruncationSelector implements Selector {
  @Override
  public ArrayList<Individual> select(ArrayList<Individual> population, Encoding desired) {
    for (Individual individual : population) {
      individual.calculateFitness(desired);
    }
    Collections.sort(population);
    return new ArrayList<>(population.subList(population.size() / 2, population.size()));
  }
}
