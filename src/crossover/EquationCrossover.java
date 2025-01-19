package crossover;

import gene.Equation;
import gene.Individual;
import gene.encoding.Encoding;
import util.Node;
import util.OperatorNode;
import util.TerminalNode;

import java.util.List;
import java.util.Random;

public class EquationCrossover implements Crossover<List<double[]>> {
  @Override
  public Individual<List<double[]>>[] doCrossover(Individual<List<double[]>> parent1, Individual<List<double[]>> parent2) {
    if (!(parent1 instanceof Equation) || !(parent2 instanceof Equation)) {
      throw new IllegalArgumentException();
    }
    Individual<List<double[]>> child1 = parent1.copy();
    Individual<List<double[]>> child2 = parent2.copy();
    Node[] crossover1 = getRandomNodeAndParent((Node)(child1.getEncoding()), null);
    Node[] crossover2 = getRandomNodeAndParent((Node)(child2.getEncoding()), null);
    Node node1 = crossover1[0];
    Node parentNode1 = crossover1[1];
    Node node2 = crossover2[0];
    Node parentNode2 = crossover2[1];
    if (((OperatorNode) parentNode1).getLeft() == node1) {
      ((OperatorNode) parentNode1).setLeft(node2);
    }
    else {
      ((OperatorNode) parentNode1).setRight(node2);
    }
    if (((OperatorNode) parentNode2).getLeft() == node2) {
      ((OperatorNode) parentNode2).setLeft(node1);
    }
    else {
      ((OperatorNode) parentNode2).setRight(node1);
    }
    return (Individual<List<double[]>>[]) new Individual[]{child1, child2};
  }

  private static Node[] getRandomNodeAndParent(Node root, Node parent) {
    if (root == null) {
      return null;
    }
    if (root instanceof TerminalNode && parent != null) {
      return new Node[] {root, parent};
    }
    Random rand = new Random();
    if (parent != null) {
      return rand.nextBoolean() ? new Node[] {root, parent} : rand.nextBoolean() ? getRandomNodeAndParent(((OperatorNode) root).getLeft(), root) : getRandomNodeAndParent(((OperatorNode) root).getRight(), root);
    }
    else {
      return rand.nextBoolean() ? getRandomNodeAndParent(((OperatorNode) root).getLeft(), root) : getRandomNodeAndParent(((OperatorNode) root).getRight(), root);
    }
  }
}
