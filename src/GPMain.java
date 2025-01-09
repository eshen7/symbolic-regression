import crossover.Crossover;
import fitness.Fitness;
import gene.BitString;
import gene.Individual;
import gene.encoding.Encoding;
import generator.Generator;
import selection.Selector;

import java.util.*;

public class GPMain {
  ArrayList<Individual> population = new ArrayList<Individual>();
  Generator generator;
  Crossover crossoverFunction;
  Selector selector;
  Fitness fitnessFunction;
  int generation = 0;

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

  public void runOneGeneration(Encoding desired) {
    generation++;
    Collections.shuffle(population);
    int pop = population.size();
    for (int i = 0; i < pop - 1; i+= 2) {
      doCrossover(population.get(i), population.get(i + 1));
    }
    population = selector.select(population, desired);
    mutateAll();
    display();
  }

  public void mutateAll() {
    for (Individual individual : population) {
      individual.mutate();
    }
  }

  public void doCrossover(Individual parent1, Individual parent2) {
    Individual[] children = crossoverFunction.doCrossover(parent1, parent2);
    population.addAll(Arrays.asList(children));
  }

  public void display() {
    System.out.println("Generation: " + generation);
    Collections.sort(population);
    for (int i = population.size() - 1; i >= population.size() - 10; i--) {
      System.out.println(population.get(i).toString());
    }
  }

  public void runOnData() {
  }
}
