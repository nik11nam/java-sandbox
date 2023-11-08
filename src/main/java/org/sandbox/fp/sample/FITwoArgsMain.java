package org.sandbox.fp.sample;

import org.sandbox.fp.utils.FITwoArgs;

public class FITwoArgsMain {

    public static void main(String[] args) {
        FITwoArgs fiTwoArgs1 = (x, y) -> x + y;
        System.out.println(fiTwoArgs1.call("Hello", "World"));

        FITwoArgs fiTwoArgs2 = (x, y) -> {
            String string = new StringBuilder()
                    .append(x)
                    .append(y)
                    .toString();
            return string;
        };
        System.out.println(fiTwoArgs2.call("American", "Loser"));
    }

}
