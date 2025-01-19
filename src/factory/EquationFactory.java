package factory;

import fitness.EquationFitness;
import gene.Equation;
import gene.Individual;
import generator.EquationGenerator;

import java.util.ArrayList;
import java.util.List;

public class EquationFactory implements Factory<List<double[]>>{
  ArrayList<Individual<List<double[]>>> population = new ArrayList<>();
  EquationGenerator generator = new EquationGenerator();
  EquationFitness fitness = new EquationFitness();

  @Override
  public void createPopulation(int size, int length, double mutationRate) {
    for (int i = 0; i < size; i++) {
      population.add(new Equation(generator.generate(length), fitness, mutationRate));
    }
  }

  @Override
  public ArrayList<Individual<List<double[]>>> getPopulation() {
    return population;
  }
}
