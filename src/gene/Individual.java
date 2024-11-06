package gene;

import fitness.Fitness;
import mutation.Mutation;

public abstract class Individual implements Comparable<Individual> {
  protected String encoding;
  protected Fitness fitnessFunction;
  protected Mutation mutationFunction;
  protected double fitness;
  protected double mutationRate;

  public Individual(String encoding, Fitness fitnessFunction, Mutation mutationFunction, double mutationRate) {
    this.encoding = encoding;
    this.fitnessFunction = fitnessFunction;
    this.mutationFunction = mutationFunction;
    this.mutationRate = mutationRate;
  }

  public void setMutationRate(double mutationRate) {
    this.mutationRate = mutationRate;
  }

  public double getMutationRate() {
    return this.mutationRate;
  }

  public double calculateFitness(String desired) {
    this.fitness = this.fitnessFunction.calculateFitness(this, desired);
    return this.fitness;
  }

  public void mutate() {
    this.mutationFunction.mutate(this);
  }

  public String getEncoding() {
    return this.encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  public abstract Individual copy();

  @Override
  public int compareTo(Individual o) {
    double fitnessThis = this.fitness;
    double fitnessOther = o.fitness;

    return Double.compare(fitnessThis, fitnessOther);
  }
}
