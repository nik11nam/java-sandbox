package org.sandbox.oops.threads.lockfree;

import java.util.concurrent.atomic.AtomicReference;

/**
 * https://github.com/byronlai/lock-free-data-structures/blob/master/Stack.java
 *
 * @param <T>
 */
public class AtomicStack<T> {

    AtomicReference<Node<T>> top = new AtomicReference<>();

    public void push(T value) {
        boolean successful = false;
        while (!successful) {
            Node<T> oldTop = top.get();
            Node<T> newTop = new Node<T>(value, oldTop);
            successful = top.compareAndSet(oldTop, newTop);
        };
    }

    public T peek() {
        return top.get().value;
    }

    public T pop() {
        boolean successful = false;
        Node<T> newTop = null;
        Node<T> oldTop = null;
        while (!successful) {
            oldTop = top.get();
            newTop = oldTop.next;
            successful = top.compareAndSet(oldTop, newTop);
        }
        return oldTop.value;
    }

    private class Node<T> {
        private volatile Node<T> next;
        private volatile T value;

        public Node(T value, Node<T> next) {
            this.next = next;
            this.value = value;
        }
    }

}
