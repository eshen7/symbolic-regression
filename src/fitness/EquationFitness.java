package fitness;

import gene.encoding.Encoding;
import util.Node;
import util.TerminalNode;
import util.OperatorNode;
import java.util.List;

public class EquationFitness implements Fitness<List<double[]>> {
  @Override
  public double calculateFitness(Encoding encoding, List<double[]> data) {
    if(!(encoding instanceof Node)) {
      throw new IllegalArgumentException();
    }
    double error = 0.0;
    for (double[] point : data) {
      double x = point[0];
      double expected = point[1];
      double predicted = ((Node) encoding).evaluate(x);
      error -= Math.pow(expected - predicted, 2);  // Mean Squared Error
    }
    return error / data.size() + 1.0 / getNodeCount((Node) encoding);
  }

  public static int getNodeCount(Node root) {
    if (root == null) return 0;
    if (root instanceof TerminalNode) return 1;
    return 1 + getNodeCount(((OperatorNode) root).getLeft()) + getNodeCount(((OperatorNode) root).getRight());
  }
}
