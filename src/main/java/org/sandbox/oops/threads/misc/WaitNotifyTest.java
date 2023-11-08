package org.sandbox.oops.threads.misc;

/**
 * https://medium.com/swlh/low-level-concurrency-in-java-3eb96f5426c5
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        ThreadHut threadHut = new ThreadHut();

        Thread customer = new Thread(() -> {
            try {
                threadHut.orderPizza();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread chef = new Thread(() -> {
            try {
                threadHut.preparePizza();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        customer.start();
        chef.start();
    }
}

class ThreadHut {

    private boolean pizzaReady = false;

    public synchronized void orderPizza() throws InterruptedException {
        while (!pizzaReady) {
            System.out.println("Waiting for pizza");
            this.wait();
        }
        System.out.println("Yay! Got the pizza!");
    }

    public synchronized void preparePizza() throws InterruptedException {
        System.out.println("Preparing pizza. Please wait 5 seconds.");
        Thread.sleep(5 * 1000);
        pizzaReady = true;
        System.out.println("Pizza ready");
        this.notify();
    }

}
