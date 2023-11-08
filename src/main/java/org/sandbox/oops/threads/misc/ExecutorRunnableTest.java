package org.sandbox.oops.threads.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorRunnableTest {
    public static void main(String[] args) {
        // pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // creates 4 runnables to be executed
        for (int i = 0; i < 10; i++) {
            TaskRun runnable = new TaskRun();
            executorService.execute(runnable);
        }
        executorService.shutdown(); // shuts down the executor service
    }
}

class TaskRun implements Runnable {
    @Override
    public void run() {
        System.out.println("I am " + Thread.currentThread().getName());
    }
}
