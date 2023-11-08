package org.sandbox.oops.threads.misc;

import java.util.Random;

public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of main thread");

        Thread ping = new Thread(() -> {
            for (int i=0; i<3; i++) {
                try { Thread.sleep(new Random().nextInt(2000)); }
                catch (InterruptedException e) { }
                System.out.println("ping");
            }
        });
        ping.setName("Ping Thread");

        Thread pong = new Thread(() -> {
           for (int i=0; i<3; i++) {
               try { Thread.sleep(new Random().nextInt(2000)); }
               catch (InterruptedException e) { }
               System.out.println("pong");
           }
        });
        pong.setName("Pong Thread");

        ping.start();
        pong.start();

        // To ensure that the main thread finish its execution after the worker threads,
        // we can join it, pausing its execution while the worker threads are alive
        ping.join();
        pong.join();

        System.out.println("End of main thread");
    }

}
