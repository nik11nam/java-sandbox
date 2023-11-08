package org.sandbox.oops.java8.feature;

import java.util.function.*;

/**
 * https://dzone.com/articles/be-more-functional-javas-functional-interfaces
 */
public class FunctionalTest {

    public static void main(String[] args) {
        f_consumer();
        f_predicate();
        f_function();
        f_bifunction();
        f_supplier();
    }

    private static void f_consumer() {
        System.out.println("******** Consumer ********");
        Consumer<Integer> printAgeConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer age) {
                System.out.println("Age is " + age);
            }
        };
        printAgeConsumer.accept(100);

        Consumer<Integer> printAgeLambda = (age) -> System.out.println("Lambda : age is " + age);
        printAgeLambda.accept(100);

        //Method chaining
        printAgeConsumer
                .andThen(printAgeLambda)
                .andThen(age -> System.out.println("How old is he? " + age))
                .accept(100);
    }

    private static void f_predicate() {
        System.out.println("******** Predicate ********");
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number%2 == 0;
            }
        };
        System.out.println(isEven.test(23));

        Predicate<Integer> isEvenLambda = (number) -> number%2 == 0;
        System.out.println(isEvenLambda.test(46));

        //Method chaining
        boolean value = isEven
                            .and(n -> n < 10)
                            .and(n -> n > 4)
                            .test(6);
        System.out.println(value);
    }

    private static void f_function() {
        System.out.println("******** Function ********");
        Function<Integer, Integer> doubleNumber = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * 2;
            }
        };
        System.out.println(doubleNumber.apply(3));

        Function<Integer, Integer> subtractNumber = (number) -> number - 2;
        System.out.println(subtractNumber.apply(4));

        //Method chaining
        int value = doubleNumber
                        .andThen(subtractNumber)
                        .andThen(doubleNumber)
                        .apply(3);
        System.out.println(value);
    }

    private static void f_bifunction() {
        System.out.println("******** BiFunction ********");
        BiFunction<Integer, Integer, Integer> areaRectangle = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer length, Integer breadth) {
                return length * breadth;
            }
        };
        System.out.println(areaRectangle.apply(4, 2));

        BiFunction<Integer, Integer, String> areaMessage = (l, b) -> "Area is: " + l * b;
        System.out.println(areaMessage.apply(4, 2));

        //Method chaining
        int value = areaRectangle
                    .andThen(area -> area * 3)
                    .apply(4, 2);
        System.out.println(value);
    }

    private static void f_supplier() {
        System.out.println("******** Supplier ********");
        Supplier<Double> randomSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        System.out.println("Random number: " + randomSupplier.get());

        Supplier<String> codersTeaUrl = () -> "http://coderstea.com";
        System.out.println(codersTeaUrl.get());
    }

}
