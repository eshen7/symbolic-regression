package selection;

import gene.Individual;

import java.util.List;

public interface Selector {
  List<Individual> select(List<Individual> population);
}
