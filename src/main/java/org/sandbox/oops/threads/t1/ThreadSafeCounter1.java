package org.sandbox.oops.threads.t1;

/**
 * https://stackoverflow.com/questions/29883719/java-multithreading-threadsafe-counter/29884069
 * The phenomenon you are seeing is called thread starvation. Upon entering the guarded portion of your code
 * (sorry I missed this earlier), other threads will need to block until the thread holding the monitor is done
 * (i.e. when the monitor is released). Whilst one may expect the current thread pass the monitor to the next thread
 * waiting in line, for synchronized blocks, java does not guarantee any fairness or ordering policy to which thread
 * next recieves the monitor. It is entirely possible (and even likely) for a thread that releases and attempts to
 * reacquire the monitor to get hold of it over another thread that has been waiting for a while.
 */
public class ThreadSafeCounter1 implements Runnable {

    static int counter = 1; // a global counter

    public ThreadSafeCounter1() {
    }

    static synchronized void incrementCounter() {
        System.out.println(Thread.currentThread().getName() + ": " + counter);
        counter++;
    }

    @Override
    public void run() {
        while(counter<1000){
            incrementCounter();
        }
    }

    public static void main(String[] args) {
        ThreadSafeCounter1 te = new ThreadSafeCounter1();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);

        thread1.start();
        thread2.start();
    }
}
