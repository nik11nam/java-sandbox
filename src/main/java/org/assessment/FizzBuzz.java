package org.assessment;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz.fizzBuzz(15);
    }

    private static void fizzBuzz(int n) {
        for (int i=1; i<=n; i++) {
            if (i%5 == 0 && i%3 ==0) {
                System.out.println("FizzBuzz");
            } else if (i%3 == 0) {
                System.out.println("Fizz");
            } else if (i%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
