package util;

import generator.EquationGenerator;
import util.Node;

import java.util.Random;

public class OperatorNode extends Node {

  public enum Operator {
    PLUS(0),
    MINUS(1),
    MULTIPLY(2),
    DIVIDE(3);

    private final int value;

    Operator(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    @Override
    public String toString() {
      return switch (this) {
        case PLUS -> "+";
        case MINUS -> "-";
        case MULTIPLY -> "*";
        case DIVIDE -> "/";
        default -> throw new IllegalArgumentException();
      };
    }
  }

  private Node left, right;
  private Operator operator;
  private Random rand = new Random();
  Operator[] operators = Operator.values();

  public OperatorNode(Operator operator, Node left, Node right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  @Override
  public double evaluate(double x) {
    double leftVal = left.evaluate(x);
    double rightVal = right.evaluate(x);
    return switch (operator) {
      case PLUS -> leftVal + rightVal;
      case MINUS -> leftVal - rightVal;
      case MULTIPLY -> leftVal * rightVal;
      case DIVIDE -> (rightVal != 0) ? leftVal / rightVal : 1;
    };
  }

  @Override
  public Node copy() {
    return new OperatorNode(operator, left.copy(), right.copy());
  }

  @Override
  public String getData() {
    return "(" + left.getData() + ") " + operator + " (" + right.getData() + ")";
  }

  @Override
  public void mutate(double mutationRate) {
    if (rand.nextDouble() > mutationRate) {
      return;
    }
    if (rand.nextBoolean()) {
       OperatorNode newNode = (OperatorNode) EquationGenerator.generateRandomTree(5, true);
       this.setLeft(newNode.getLeft());
       this.setRight(newNode.getRight());
       this.operator = newNode.getOperator();
       return;
    }
    this.operator = operators[rand.nextInt(operators.length)];
  }
}
