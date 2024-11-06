package selection;

import gene.Individual;

import java.util.Collections;
import java.util.List;

public class TruncationSelector implements Selector {
  @Override
  public List<Individual> select(List<Individual> population) {
    Collections.sort(population);
    return population.subList(population.size() / 2, population.size());
  }
}
