import crossover.Crossover;
import factory.Factory;
import fitness.Fitness;
import gene.BitString;
import gene.Equation;
import gene.Individual;
import gene.encoding.Encoding;
import generator.Generator;
import selection.Selector;
import util.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static fitness.EquationFitness.getNodeCount;

public class GPMain<T> {
  ArrayList<Individual<T>> population = new ArrayList<Individual<T>>();
  Generator generator;
  Crossover<T> crossoverFunction;
  Selector<T> selector;
  Factory<T> factory;
  int generation = 0;

  public GPMain(Generator generator, Crossover<T> crossoverFunction, Selector<T> selector, Factory<T> factory) {
    this.generator = generator;
    this.crossoverFunction = crossoverFunction;
    this.selector = selector;
    this.factory = factory;
  }

  public void createPopulation(int populationSize, int geneLength, double mutationRate) {
    factory.createPopulation(populationSize, geneLength, mutationRate);
    this.population = factory.getPopulation();
  }

  public void runOneGeneration(T desired) {
    display();
    generation++;
    Collections.shuffle(population);
    int pop = population.size();
    for (int i = 0; i < pop - 1; i+= 2) {
      doCrossover(population.get(i), population.get(i + 1));
    }
    population = selector.select(population, desired);
    mutateAll();
  }

  public void mutateAll() {
    for (Individual<T> individual : population) {
      individual.mutate();
    }
  }

  public void doCrossover(Individual<T> parent1, Individual<T> parent2) {
    Individual<T>[] children = crossoverFunction.doCrossover(parent1, parent2);
    population.addAll(Arrays.asList(children));
  }

  public void display() {
    System.out.println("Generation: " + generation);
    Collections.sort(population);
    for (int i = population.size() - 1; i >= population.size() - Math.min(10, population.size()); i--) {
      System.out.println(population.get(i).toString());
    }
  }

  public void runOnData(T data) {
  }
}
