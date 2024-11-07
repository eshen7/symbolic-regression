import crossover.Crossover;
import fitness.Fitness;
import gene.BitString;
import gene.Individual;
import gene.encoding.Encoding;
import generator.Generator;
import selection.Selector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GPMain {
  List<Individual> population = new ArrayList<Individual>();
  Generator generator;
  Crossover crossoverFunction;
  Selector selector;
  Fitness fitnessFunction;

  public GPMain(Generator generator, Crossover crossoverFunction, Selector selector,
      Fitness fitnessFunction) {
    this.generator = generator;
    this.crossoverFunction = crossoverFunction;
    this.selector = selector;
    this.fitnessFunction = fitnessFunction;
  }

  public void createPopulation(int populationSize) {
    for (int i = 0; i < populationSize; i++) {
      Encoding encoding = generator.generate(100);
      population.add(new BitString(encoding, fitnessFunction, 0.1));
    }
  }

  public void runOneGeneration() {
  }

  public void doCrossover(Individual parent1, Individual parent2) {
    Individual[] children = crossoverFunction.doCrossover(parent1, parent2);
    Collections.addAll(population, children);
  }

  public void display() {
  }

  public void runOnData() {
  }
}
