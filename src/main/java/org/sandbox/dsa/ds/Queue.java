package org.sandbox.dsa.ds;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The elements enter the queue at the rear(back) i.e the Tail and exit towards the head(front) of the queue
 */
public class Queue {

    private Deque<Integer> deque;

    public Queue() {
        deque = new LinkedList<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // O(1)
    public void add(Integer value) {
        deque.addLast(value);
    }

    // O(1)
    public Integer remove() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.removeFirst();
    }

    // O(1)
    public Integer peek() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.getFirst();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
