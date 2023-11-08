package org.sandbox.oops.threads.t3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html
 */
public class ProducerConsumerPattern2 {

    public static void main(String args[]){
        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread producer = new Thread(new Producer1(sharedQueue));
        Thread consumer = new Thread(new Consumer1(sharedQueue));

        //Starting producer and Consumer thread
        producer.start();
        consumer.start();
    }
}

class Producer1 implements Runnable {

    private final BlockingQueue sharedQ;

    public Producer1(BlockingQueue sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQ.put(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class Consumer1 implements Runnable {

    private final BlockingQueue sharedQ;

    public Consumer1(BlockingQueue sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true){
            try {
                int number = (int) sharedQ.take();
                System.out.println("Consumed: "+ number);

                if (number == 10) {
                    break;
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
