package org.sandbox.oops.threads.lockfree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-concurrency-advanced-3/src/main/java/com/baeldung/atomicstampedreference/StampedAccount.java
 */
public class AtomicStampedAccount {

    private final AtomicInteger stamp = new AtomicInteger(0);
    private final AtomicStampedReference<Integer> account = new AtomicStampedReference<>(0, 0);

    public boolean deposit(int funds) {
        int[] stamps = new int[1];
        int current = this.account.get(stamps);
        int newStamp = this.stamp.incrementAndGet();

        // Thread is paused here to allow other threads to update the stamp and amount (for testing only)
        sleep();

        return this.account.compareAndSet(current, current + funds, stamps[0], newStamp);
    }

    public boolean withdrawal(int funds) {
        int[] stamps = new int[1];
        int current = this.account.get(stamps);
        int newStamp = this.stamp.incrementAndGet();
        return this.account.compareAndSet(current, current - funds, stamps[0], newStamp);
    }

    public int getBalance() {
        return account.getReference();
    }

    public int getStamp() {
        return account.getStamp();
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignored) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicStampedAccount account = new AtomicStampedAccount();

        Thread t1 = new Thread(() -> {
            while (!account.deposit(100)) {
                Thread.yield();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (!account.withdrawal(100)) {
                Thread.yield();
            }
        });
        t2.start();

        t1.join(10_000);
        t2.join(10_000);

        assert (t1.isAlive());
        assert (t2.isAlive());

        assert 0 == account.getBalance();
        assert account.getStamp() > 0;
    }
}
