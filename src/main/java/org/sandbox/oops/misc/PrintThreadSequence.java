package org.sandbox.oops.misc;

public class PrintThreadSequence {

    final static int MAX_NUMBERS = 10;

    public static void main(String[] args) {
        // shared object
        PrintThreadSequence obj = new PrintThreadSequence();
        // Creating 3 threads
        Thread t1 = new Thread(new NumberRunnable(obj, 0), "T1");
        Thread t2 = new Thread(new NumberRunnable(obj, 1), "T2");
        Thread t3 = new Thread(new NumberRunnable(obj, 2), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class NumberRunnable implements Runnable {
    PrintThreadSequence obj;
    int threadNumber;
    static int number = 0;

    NumberRunnable(PrintThreadSequence obj, int threadNumber) {
        this.obj = obj;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        while (number < PrintThreadSequence.MAX_NUMBERS) {
            synchronized (obj) {
                // check again for (number < PrintThreadSequence.MAX_NUMBERS) otherwise one more number my be
                // printed by another thread
                if (number % 3 == threadNumber && number < PrintThreadSequence.MAX_NUMBERS) {
                    System.out.println(Thread.currentThread().getName() + " - " + ++number);
                }
            }
        }
    }
}
