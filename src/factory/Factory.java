package factory;

import gene.Individual;

import java.util.ArrayList;

public interface Factory<T> {
  void createPopulation(int size, int length, double mutationRate);

  ArrayList<Individual<T>> getPopulation();
}
