package org.sandbox.oops.misc;

public class SwappingNumberWithoutTempVariable {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println("Initially --> a: " + a + " ,b: " + b);

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Final --> a: " + a + " ,b: " + b);
    }

}
