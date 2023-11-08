package org.sandbox.oops.threads.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableTest {

    public static void main(String[] args) {
        // pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = new ArrayList<>();
        // creates 10 callables to be executed
        for (int i = 0; i < 10; i++) {
            TaskCall callable = new TaskCall();
            Future<String> future = executorService.submit(callable);
            futures.add(future);
        }

        // getting tasks results
        futures.forEach(f -> {
            try { System.out.println(f.get()); }
            catch (Exception e) { }
        });

        executorService.shutdown(); // shuts down the executor service
    }
}

class TaskCall implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "I am " + Thread.currentThread().getName();
    }
}
