package org.mosh.dsa.part1;

// We need two stacks to implement a min stack.
// One stack holds the values, the other stack
// (called minStack) holds the minimums.
public class MinStack {
  private Stack stack = new Stack();
  private Stack minStack = new Stack();

  public void push(int item) {
    stack.push(item);

    if (minStack.isEmpty())
      minStack.push(item);
    else if (item < minStack.peek())
      minStack.push(item);
  }

  public int pop() {
    if (stack.isEmpty())
      throw new IllegalStateException();

    int top = stack.pop();

    if (minStack.peek() == top)
      minStack.pop();

    return top;
  }

  public int min() {
    return minStack.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(5);
    minStack.push(1);
    minStack.push(10);
    minStack.push(2);

    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.min());
  }
}
