package org.sandbox.oops.threads.t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://www.javatpoint.com/java-thread-pool
 *
 * Java Thread pool represents a group of worker threads that are waiting for the job and reuse many times.
 * In case of thread pool, a group of fixed size threads are created. A thread from the thread pool is pulled out
 * and assigned a job by the service provider. After completion of the job, thread is contained in the thread pool again.
 * ex: It is used in Servlet and JSP where container creates a thread pool to process the request.
 */
public class ThreadPoolWorker implements Runnable {

    private String message;

    public ThreadPoolWorker(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+ message);
        processMessage(); // call processMessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName()+" (End)");
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new ThreadPoolWorker("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) { }

        System.out.println("Finished all threads");
    }
}
