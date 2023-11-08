package org.sandbox.dsa.algo.array;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        String[] strArray = {"Hello", "World", "Nikhil", "John", "Koshi"};

        String[] reversed = new String[strArray.length];
        int index = 0;

        /*for (int i= strArray.length-1; i>=0; i--) {
            reversed[index] = strArray[i];
            index++;
        }*/

        int count = strArray.length;
        for (int i= 0; i < strArray.length; i++) {
            reversed[index] = strArray[count - i -1];
            index++;
        }

        System.out.println(Arrays.toString(reversed));
    }

}
