package org.sandbox.dsa.ds;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Stack using LinkedList (Deque)
 * Insertions and deletions happen only at the Head of the stack
 */
public class Stack {

    private Deque<Integer> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    // O(1)
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // O(1)
    public void push(Integer value) {
        stack.addFirst(value);
    }

    // O(1)
    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.removeFirst();
    }

    // O(1)
    public Integer peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.getFirst();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
