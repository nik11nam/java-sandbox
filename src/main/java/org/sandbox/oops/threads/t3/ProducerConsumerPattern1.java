package org.sandbox.oops.threads.t3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://javarevisited.blogspot.com/2013/12/inter-thread-communication-in-java-wait-notify-example.html
 */
public class ProducerConsumerPattern1 {

    public static void main(String[] args) {
        final Queue queue = new LinkedList();

        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);

        consumer.start();
        producer.start();
    }

}

class Producer extends Thread {
    private final Queue sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        for (int i=0; i<=3; i++) {
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (!sharedQ.isEmpty()) {
                    try {
                        System.out.println("Queue is full, waiting...");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing: " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}

class Consumer extends Thread {
    private final Queue sharedQ;

    public Consumer(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, waiting...");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = (int) sharedQ.poll();
                System.out.println("Consuming: " + number);
                sharedQ.notify();

                // termination condition
                if (number == 3) {
                    break;
                }
            }
        }
    }
}
