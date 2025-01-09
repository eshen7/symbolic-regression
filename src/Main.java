import crossover.BitStringCrossover;
import crossover.Crossover;
import fitness.BitStringFitness;
import fitness.Fitness;
import gene.encoding.BitStringEncoding;
import gene.encoding.Encoding;
import generator.BitStringGenerator;
import generator.Generator;
import selection.RankSelector;
import selection.Selector;
import selection.TruncationSelector;

public class Main {
  public static void main(String[] args) {
    Generator generator = new BitStringGenerator();
    Crossover crossover = new BitStringCrossover();
    Selector selector = new TruncationSelector();
    Fitness fitness = new BitStringFitness();
    GPMain main = new GPMain(generator, crossover, selector, fitness);
    Encoding desired = generator.generate(100);
    main.createPopulation(100);
    for (int i = 0; i < 100; i++) {
      main.runOneGeneration(desired);
    }
    System.out.println("Desired: " + desired.getData());
  }
}
