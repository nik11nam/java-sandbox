package org.sandbox.oops.threads.t5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier is another concurrency utility introduced in Java 5 which is used when a number
 * of threads (also known as parties) want to wait for each other at a common point, also known
 * as the barrier before starting processing again.
 * The barrier will not be broken until all parties are arrived. A party (thread) is said to be
 * arrived with it call barrier.await() method.
 *
 * Read more: https://www.java67.com/2015/06/how-to-use-cyclicbarrier-in-java.html#
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);

        Party first = new Party(1000, barrier, "PARTY-1");
        Party second = new Party(2000, barrier, "PARTY-2");
        Party third = new Party(3000, barrier, "PARTY-3");
        Party fourth = new Party(4000, barrier, "PARTY-4");

        first.start();
        second.start();
        third.start();
        fourth.start();

        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}

class Party extends Thread {
    private int delay;
    private CyclicBarrier barrier;

    public Party(int delay, CyclicBarrier barrier, String name) {
        super(name);
        this.delay = delay;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " is calling await");
            // Blocking :
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
