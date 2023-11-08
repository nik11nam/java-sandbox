package org.sandbox.oops.threads.lockfree;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-concurrency-advanced-3/src/main/java/com/baeldung/lockfree/NonBlockingQueue.java
 *
 * @param <T>
 */
public class AtomicQueue<T> {

    private final AtomicReference<Node<T>> head, tail;
    private final AtomicInteger size;

    public AtomicQueue() {
        head = new AtomicReference<>(null);
        tail = new AtomicReference<>(null);
        size = new AtomicInteger();
        size.set(0);
    }

    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node<T> node = new Node<>(element);
        Node<T> currentTail;
        do {
            currentTail = tail.get();
            node.setPrevious(currentTail);
        } while(!tail.compareAndSet(currentTail, node));

        if(node.previous != null) {
            node.previous.next = node;
        }

        head.compareAndSet(null, node); //if we are inserting the first element
        size.incrementAndGet();
    }

    public T get() {
        if(head.get() == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentHead;
        Node<T> nextNode;
        do {
            currentHead = head.get();
            nextNode = currentHead.getNext();
        } while(!head.compareAndSet(currentHead, nextNode));

        size.decrementAndGet();
        return currentHead.getValue();
    }

    public int size() {
        return this.size.get();
    }

    private class Node<T> {
        private final T value;
        private volatile Node<T> next;
        private volatile Node<T> previous;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
