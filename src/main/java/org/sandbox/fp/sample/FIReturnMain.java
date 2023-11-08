package org.sandbox.fp.sample;

import org.sandbox.fp.utils.FIReturn;

public class FIReturnMain {

    public static void main(String[] args) {
        FIReturn fiReturn1 = () -> 5;
        System.out.println(fiReturn1.call());

        FIReturn fiReturn2 = () -> {
            int x = 100;
            return x++;
        };
        System.out.println(fiReturn2.call());
    }

}
