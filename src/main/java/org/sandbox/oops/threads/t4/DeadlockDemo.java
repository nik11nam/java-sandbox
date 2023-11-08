package org.sandbox.oops.threads.t4;

/**
 * Nested synchronization block with circular wait
 * https://javarevisited.blogspot.com/2018/08/how-to-avoid-deadlock-in-java-threads.html#axzz6cjBIIXs3
 */
public class DeadlockDemo {

    /*
     * This method request two locks, first String and then Integer
     */
    public void method1() {
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println("Acquired lock on Integer.class object");
            }
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println("Acquired lock on String.class object");
            synchronized (String.class) {
                System.out.println("Acquired lock on Integer.class object");
            }
        }
    }

}
