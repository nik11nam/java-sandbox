package org.sandbox.dsa.algo.array;

// Find largest and smallest number in array
public class FindMinMaxInArray {

    public static void main(String[] args) {
        int number[] = {10, 50, 5, 20, 100, 3000, 4, 30};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<number.length; i++) {
            if (number[i] > max) {
                max = number[i];
            } else if (number[i] < min) {
                min = number[i];
            }
        }

        System.out.println("Max: " + max + ", Min:" + min);
    }

}
