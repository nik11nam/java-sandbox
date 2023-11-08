package org.sandbox.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;
import java.util.stream.IntStream;

public class MicroBenchMark {

    @Benchmark
    public void sum() {
        // Sequential
        IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);
        // Parallel
        IntStream.rangeClosed(1, 100).parallel().reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

}
