package org.sandbox.oops.threads.t1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter3 implements Runnable {

    static AtomicInteger counter = new AtomicInteger(1); // a global counter

    public ThreadSafeCounter3() {
    }

    static void incrementCounter() {
        System.out.println(Thread.currentThread().getName() + ": " + counter.getAndIncrement());
    }

    @Override
    public void run() {
        while(counter.get() < 1000){
            incrementCounter();
        }
    }

    public static void main(String[] args) {
        ThreadSafeCounter3 te = new ThreadSafeCounter3();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);

        thread1.start();
        thread2.start();
    }
}
