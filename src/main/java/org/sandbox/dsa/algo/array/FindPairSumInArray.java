package org.sandbox.dsa.algo.array;

import java.util.HashSet;
import java.util.Set;

// Program to find all pairs of integers whose sum is equal to a given number
public class FindPairSumInArray {

    public static void main(String[] args) {
        int[] numbers = {2,4,3,7,5,8,9};
        int[] numbersWithDuplicates = {2,4,3,5,6,-2,4,7,8,9};

        printPair(numbers, 7);
        printPair(numbersWithDuplicates, 7);
    }

    private static void printPair(int[] numbers, int sum) {
        if (numbers.length < 2)
            return;

        System.out.println("===============");
        Set<Integer> store = new HashSet<>();
        for (int value : numbers) {
            int target = sum - value;

            if (store.contains(target)) {
                System.out.println("Pair: {" + value + "," + target + "}");
            } else {
                store.add(value);
            }
        }
    }
}
