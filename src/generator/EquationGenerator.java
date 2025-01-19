package generator;

import gene.encoding.Encoding;
import util.Node;
import util.OperatorNode;
import util.TerminalNode;

import java.util.Random;

public class EquationGenerator implements Generator {
  private static final Random rand = new Random();

  @Override
  public Encoding generate(int length) {
    return generateRandomTree(length, true);
  }

  public static Node generateRandomTree(int maxDepth, boolean root) {
    if (maxDepth == 0 || (rand.nextDouble() < 0.3 && !root)) {
      return generateRandomTerminal();
    }

    OperatorNode.Operator randomOperator = getRandomOperator();
    Node leftChild = generateRandomTree(maxDepth - 1, false);
    Node rightChild = generateRandomTree(maxDepth - 1, false);

    return new OperatorNode(randomOperator, leftChild, rightChild);
  }

  private static Node generateRandomTerminal() {
    if (rand.nextBoolean()) {
      return new TerminalNode(true);
    } else {
      return new TerminalNode(rand.nextDouble() * 10);
    }
  }

  private static OperatorNode.Operator getRandomOperator() {
    OperatorNode.Operator[] operators = OperatorNode.Operator.values();
    return operators[rand.nextInt(operators.length)];
  }
}
