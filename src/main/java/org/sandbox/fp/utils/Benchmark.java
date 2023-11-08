package org.sandbox.fp.utils;

import java.util.function.Supplier;

public class Benchmark {

    public static <T> T profile(Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        long end = System.currentTimeMillis();

        System.out.println(String.format("Function finished in: %d ms", end - start));
        return result;
    }

    public static <T> Pair<Long, T> benchmark(Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        long end = System.currentTimeMillis();
        return Pair.of((end - start), result);
    }

    public static <T> Long averageTime(int n, Supplier<T> supplier) {
        long total = 0;
        for(int i=0; i<n; i++) {
            long start = System.currentTimeMillis();
            supplier.get();
            long end = System.currentTimeMillis();
            total += (end - start);
        }

        return total/n;
    }

}
