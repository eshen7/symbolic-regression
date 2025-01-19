package selection;

import gene.Individual;
import gene.encoding.Encoding;

import java.util.ArrayList;
import java.util.List;

public interface Selector<T> {
  ArrayList<Individual<T>> select(ArrayList<Individual<T>> population, T desired);
}
