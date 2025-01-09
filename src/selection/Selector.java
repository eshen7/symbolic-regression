package selection;

import gene.Individual;
import gene.encoding.Encoding;

import java.util.ArrayList;
import java.util.List;

public interface Selector {
  ArrayList<Individual> select(ArrayList<Individual> population, Encoding desired);
}
