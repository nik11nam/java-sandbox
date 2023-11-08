package org.mosh.dsa.part1;

import java.util.Arrays;

/**
 * Stack using Array
 */
public class Stack {
  private int[] items = new int[5];
  private int count;

  // O(1)
  public void push(int item) {
    if (count == items.length)
      throw new StackOverflowError();

    items[count++] = item;
  }

  // O(1) - tail
  public int pop() {
    if (count == 0)
      throw new IllegalStateException();

    return items[--count];
  }

  public int peek() {
    if (count == 0)
      throw new IllegalStateException();

    return items[count - 1];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public String toString() {
    int[] content = Arrays.copyOfRange(items, 0, count);
    return Arrays.toString(content);
  }
}
