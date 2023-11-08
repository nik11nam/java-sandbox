package org.sandbox.oops.threads.t1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://stackoverflow.com/questions/29883719/java-multithreading-threadsafe-counter/29884069
 * concurrent synchronization method that supports fairness (e.g. ReentrantLock)
 */
public class ThreadSafeCounter2 implements Runnable {

    static int counter = 1; // a global counter

    static ReentrantLock counterLock = new ReentrantLock(true); // enable fairness policy

    static void incrementCounter(){
        counterLock.lock();

        // Always good practice to enclose locks in a try-finally block
        try {
            System.out.println(Thread.currentThread().getName() + ": " + counter);
            counter++;
        } finally {
            counterLock.unlock();
        }
    }

    @Override
    public void run() {
        while(counter<1000){
            incrementCounter();
        }
    }

    public static void main(String[] args) {
        ThreadSafeCounter2 te = new ThreadSafeCounter2();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);

        thread1.start();
        thread2.start();
    }
}
