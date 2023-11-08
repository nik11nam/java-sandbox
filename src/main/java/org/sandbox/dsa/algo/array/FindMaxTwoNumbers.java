package org.sandbox.dsa.algo.array;

// Find max two numbers from the array
public class FindMaxTwoNumbers {

    public static void main(String[] args){
        int number[] = {10, 50, 5, 20, 100, 3000, 4, 30};

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i=0; i<number.length; i++) {
            if (number[i] > max1) {
                max2 = max1;
                max1 = number[i];
            } else if (number[i] > max2) {
                max2 = number[i];
            }
        }

        System.out.println("Max1: " + max1 + ", Max2:" + max2);
    }

}
