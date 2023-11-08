package org.sandbox.oops.threads.t5;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch is a high-level synchronization utility which is used to prevent a particular thread
 * to start processing until all threads are ready.
 * Once the latch is open, it can't be reused.
 *
 * Read more: https://www.java67.com/2015/06/java-countdownlatch-example.html
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        Worker w1 = new Worker(1000, latch, "Worker-1");
        Worker w2 = new Worker(2000, latch, "Worker-2");
        Worker w3 = new Worker(3000, latch, "Worker-3");
        Worker w4 = new Worker(4000, latch, "Worker-4");

        w1.start();
        w2.start();
        w3.start();
        w4.start();

        // Blocking: Main thread will wait until all thread finished
        latch.await();

        System.out.println(Thread.currentThread().getName() + " has finished");
    }

}

class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
