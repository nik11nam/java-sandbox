package org.sandbox.fp.sample;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<Integer> predicate1 = x -> x > 7;
        System.out.println(predicate1.test(10));

        Predicate<String> predicate2 = str -> str.equals("Hello");
        System.out.println(predicate2.test("World"));

        result(predicate1, 5);

        result(x -> x > 2, 7);
        result(y -> y%2 == 0, 9);
        result(str -> str.charAt(0) == 'H', "Hello");

        // Chaining or function composition
        System.out.println(predicate1.
                or(x -> x < 3)
                .test(9));
        System.out.println(predicate1
                .and(x -> x < 3)
                .test(2));
        System.out.println(predicate1
                .or(x -> x < 3)
                .test(5));

        // static isEqual
        System.out.println(predicate1
                .or(Predicate.isEqual(3))
                .test(10));

        BiPredicate<String, Integer> bi = (x, y) -> x.equalsIgnoreCase("Manager") && y > 10_000;
        System.out.println(bi.test("manager", 15_000));
    }

    public static <X> void result(Predicate<X> predicate, X value) {
        System.out.println(predicate.test(value));
    }

}
