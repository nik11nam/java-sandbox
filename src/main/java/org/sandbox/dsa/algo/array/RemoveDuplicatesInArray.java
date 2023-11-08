package org.sandbox.dsa.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,1,3,5,7,9,7,8,4,8};

        System.out.println("Using Collection: " + Arrays.toString(usingCollection(numbers)));
        System.out.println("Using Array: " + Arrays.toString(usingArray(numbers)));
    }

    private static int[] usingCollection(int[] numbers) {
        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(numberList);
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] usingArray(int[] numbers) {
        int[] temp = new int[numbers.length];

        //Sort the array so that duplicates will be beside each other
        Arrays.sort(numbers);

        int duplicateCount = 0;
        int previous = -1;
        for(int i=0; i < numbers.length; i++) {
            if (i == 0) {
                temp[i] = numbers[i];
            } else {
                if (numbers[i] == previous) {
                    temp[i] = -1;
                    duplicateCount++;
                } else {
                    temp[i] = numbers[i];
                }
            }
            previous = numbers[i];
        }

        int[] results = new int[numbers.length - duplicateCount];
        int index = 0;
        for (int i=0; i < temp.length; i++) {
            if (temp[i] != -1) {
                results[index] = temp[i];
                index++;
            }
        }

        return results;
    }

}
