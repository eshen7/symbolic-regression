package crossover;

import gene.Equation;
import gene.Individual;
import gene.encoding.Encoding;
import util.Node;
import util.OperatorNode;
import util.TerminalNode;

import java.util.*;

public class EquationCrossover implements Crossover<List<double[]>> {
  static Random rand = new Random();
  @Override
  public Individual<List<double[]>>[] doCrossover(Individual<List<double[]>> parent1, Individual<List<double[]>> parent2) {
    if (!(parent1 instanceof Equation) || !(parent2 instanceof Equation)) {
      throw new IllegalArgumentException();
    }
    Individual<List<double[]>> child1 = parent1.copy();
    Individual<List<double[]>> child2 = parent2.copy();
    int maxDepth = Math.min(getMaxDepth((Node) child1.getEncoding()), getMaxDepth((Node) child2.getEncoding()));
    int targetDepth = rand.nextInt(maxDepth) + 1;
    Node[] crossover1 = getRandomNodeAtDepth((Node) child1.getEncoding(), targetDepth);
    Node[] crossover2 = getRandomNodeAtDepth((Node) child2.getEncoding(), targetDepth);
    Node node1 = crossover1[0];
    Node parentNode1 = crossover1[1];
    Node node2 = crossover2[0];
    Node parentNode2 = crossover2[1];

    if (node1 == node2) {
      return (Individual<List<double[]>>[]) new Individual[]{child1, child2};
    }

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

  public static int getMaxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    if (root instanceof OperatorNode) {

      int leftDepth = getMaxDepth(((OperatorNode) root).getLeft());
      int rightDepth = getMaxDepth(((OperatorNode) root).getRight());

      return Math.max(leftDepth, rightDepth) + 1; // Add 1 for current level
    }
    else {
      return 0;
    }
  }

  public static Node[] getRandomNodeAtDepth(Node root, int targetDepth) {
    if (root == null || targetDepth < 0) {
      return null;
    }

    Queue<Node[]> queue = new LinkedList<>();
    queue.add(new Node[]{root, null});
    int currentDepth = 0;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Node[]> levelNodes = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        Node[] nodePair = queue.poll();
        Node node = nodePair[0];
        Node parent = nodePair[1];

        levelNodes.add(new Node[]{node, parent});

        if (node instanceof OperatorNode) {
          if (((OperatorNode) node).getLeft() != null) {
            queue.add(new Node[]{((OperatorNode) node).getLeft(), node});
          }
          if (((OperatorNode) node).getRight() != null) {
            queue.add(new Node[]{((OperatorNode) node).getRight(), node});
          }
        }
      }

      if (currentDepth == targetDepth) {
        Random rand = new Random();
        return levelNodes.get(rand.nextInt(levelNodes.size()));
      }

      currentDepth++;
    }

    return null;
  }
}
