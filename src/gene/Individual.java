package gene;

import fitness.Fitness;
import gene.encoding.Encoding;

public abstract class Individual<T> implements Comparable<Individual<T>> {
  protected Encoding encoding;
  protected Fitness<T> fitnessFunction;
  protected double fitness;
  protected double mutationRate;

  public Individual(Encoding encoding, Fitness<T> fitnessFunction, double mutationRate) {
    this.encoding = encoding;
    this.fitnessFunction = fitnessFunction;
    this.mutationRate = mutationRate;
  }

  public double getMutationRate() {
    return this.mutationRate;
  }

  public void setMutationRate(double mutationRate) {
    this.mutationRate = mutationRate;
  }

  public double calculateFitness(T desired) {
    this.fitness = this.fitnessFunction.calculateFitness(this.encoding, desired);
    return this.fitness;
  }

  public void mutate() {
    this.encoding.mutate(this.mutationRate);
  }

  public Encoding getEncoding() {
    return this.encoding;
  }

  public abstract Individual<T> copy();

  @Override
  public int compareTo(Individual o) {
    double fitnessThis = this.fitness;
    double fitnessOther = o.fitness;

    return Double.compare(fitnessThis, fitnessOther);
  }

  public void setEncoding(Encoding encoding) {
    this.encoding = encoding;
  }

  @Override
  public String toString() {
    return "Fitness: " + this.fitness + "\nEncoding: " + this.encoding.getData() + "\n";
  }
}
