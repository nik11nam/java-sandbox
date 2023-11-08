package org.sandbox.dsa.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Find missing number in 1 to 10
public class MissingNumberInArray {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,5,6,7,8,9,10};
        int[] numbersWithDuplicates = {1,2,3,5,6,7,7,8,9,9,10};

        System.out.println("solutionForUnique: " + solutionForUnique(numbers, 10));
        System.out.println("solutionWithDuplicates: " + solutionWithDuplicates(numbersWithDuplicates, 10));
    }

    private static int solutionForUnique(int[] numbers, int count) {
        int sum = Arrays.stream(numbers).sum();
        int expectedSum = IntStream.range(1, count+1).sum();

        return expectedSum - sum;
    }

    private static int solutionWithDuplicates(int[] numbers, int count) {
        List<Integer> list = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);

        int sum = set.stream().mapToInt(temp -> temp).sum();
        int expectedSum = IntStream.range(0, count+1).sum();

        return expectedSum - sum;
    }
}
