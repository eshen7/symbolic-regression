package gene;

import fitness.Fitness;
import gene.encoding.Encoding;

public abstract class Individual implements Comparable<Individual> {
  protected Encoding encoding;
  protected Fitness fitnessFunction;
  protected double fitness;
  protected double mutationRate;

  public Individual(Encoding encoding, Fitness fitnessFunction, double mutationRate) {
    this.encoding = encoding;
    this.fitnessFunction = fitnessFunction;
    this.mutationRate = mutationRate;
  }

  public void setMutationRate(double mutationRate) {
    this.mutationRate = mutationRate;
  }

  public double getMutationRate() {
    return this.mutationRate;
  }

  public double calculateFitness(String desired) {
    this.fitness = this.fitnessFunction.calculateFitness(this.encoding, desired);
    return this.fitness;
  }

  public void mutate() {
    this.encoding.mutate(this.mutationRate);
  }

  public Encoding getEncoding() {
    return this.encoding;
  }

  public abstract Individual copy();

  @Override
  public int compareTo(Individual o) {
    double fitnessThis = this.fitness;
    double fitnessOther = o.fitness;

    return Double.compare(fitnessThis, fitnessOther);
  }
}
