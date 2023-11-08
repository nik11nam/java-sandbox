package org.sandbox.fp.sample;

import org.sandbox.fp.utils.FIVoid;

public class FIVoidMain {

    public static void main(String[] args) {

        FIVoid fiVoid1 = x -> System.out.println(x);
        fiVoid1.call(5);

        FIVoid fiVoid2 = x -> {
            x++;
            System.out.println(x);
        };
        fiVoid2.call(10);

        FIVoid fiVoid3 = x -> {
            int oddCount = 0;
            for (int i=0; i<x; i++) {
                if (i % 2 != 0) {
                    oddCount += 1;
                }
            }
            System.out.println(oddCount);
        };
        fiVoid3.call(14);
    }

}
