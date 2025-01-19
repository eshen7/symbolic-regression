package util;

import util.Node;

import java.util.Random;

public class TerminalNode extends Node {
  private Random rand = new Random();
  private double value;
  private boolean isVariable;

  public TerminalNode(double value) {
    this.value = value;
    this.isVariable = false;
  }

  public TerminalNode(boolean isVariable) {
    this.isVariable = isVariable;
  }

  @Override
  public double evaluate(double x) {
    return isVariable ? x : value;
  }

  @Override
  public Node copy() {
    return isVariable ? new TerminalNode(true) : new TerminalNode(value);
  }

  @Override
  public String getData() {
    return isVariable ? "X" : Double.toString(value);
  }

  @Override
  public void mutate(double mutationRate) {
    if (!isVariable) {
      double factor = rand.nextBoolean() ? rand.nextDouble() * 10 : 10 / rand.nextDouble();
      value *= factor;
    }
  }
}
