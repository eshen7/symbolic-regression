import crossover.BitStringCrossover;
import crossover.Crossover;
import crossover.EquationCrossover;
import factory.EquationFactory;
import factory.Factory;
import fitness.BitStringFitness;
import fitness.EquationFitness;
import fitness.Fitness;
import gene.Equation;
import gene.encoding.Encoding;
import generator.BitStringGenerator;
import generator.EquationGenerator;
import generator.Generator;
import selection.Selector;
import selection.TruncationSelector;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Generator generator = new EquationGenerator();
    Crossover<List<double[]>> crossover = new EquationCrossover();
    Selector<List<double[]>> selector = new TruncationSelector<>();
    Factory<List<double[]>> factory = new EquationFactory();
    GPMain<List<double[]>> main = new GPMain<>(generator, crossover, selector, factory);
    List<double[]> desired = new ArrayList<>();
    desired.add(new double[]{1, 4});
    desired.add(new double[]{2, 16});
    desired.add(new double[]{3, 36});
    desired.add(new double[]{4, 64});
    desired.add(new double[]{5, 100});
    main.createPopulation(500, 4, 0.7);
    for (int i = 0; i < 5000; i++) {
      main.runOneGeneration(desired);
    }
  }
}
