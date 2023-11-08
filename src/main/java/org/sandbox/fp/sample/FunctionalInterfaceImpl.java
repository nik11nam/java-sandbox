package org.sandbox.fp.sample;

import java.util.function.*;

public class FunctionalInterfaceImpl {

    public static void main (String[] args) {
        fi_consumer();
        fi_predicate();
        fi_function();
        fi_bifunction();
        fi_supplier();
    }

    private static void fi_consumer() {
        System.out.println("*********** fi_consumer ***********");
        Consumer<Integer> printAgeConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer age) {
                System.out.println("FI age is: " + age);
            }
        };
        printAgeConsumer.accept(100);

        Consumer<Integer> printAgeLambda = (age) -> System.out.println("Lambda age is: " + age);
        printAgeLambda.accept(200);

        printAgeConsumer
                .andThen(printAgeLambda)
                .andThen((age) -> System.out.println("Chain age is: " + age))
                .accept(300);
    }

    private static void fi_supplier() {
        System.out.println("*********** fi_supplier ***********");
        Supplier<Double> randomSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        System.out.println("Random supplier: " + randomSupplier.get());

        Supplier<Double> randomSupplierLambda = () -> Math.random();
        System.out.println("Random supplier(lambda): " + randomSupplierLambda.get());

        Supplier<String> urlSupplier = () -> "https://test/url";
        System.out.println("Random supplier: " + urlSupplier.get());
    }

    private static void fi_function() {
        System.out.println("*********** fi_consumer ***********");
        Function<Integer, Integer> multiply = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * 2;
            }
        };
        System.out.println("Multiplied number is: " + multiply.apply(100));

        Function<Integer, Integer> multiplyLambda = (number) -> number * 2;
        System.out.println("Multiply lambda number is: " + multiply.apply(200));

        int value = multiplyLambda
                            .andThen((number) -> number - 50)
                            .andThen((number) -> number + 10)
                            .apply(100);
        System.out.println("Multiply composition number is: " + value);
    }

    private static void fi_bifunction() {
        System.out.println("*********** fi_bifunction ***********");
        BiFunction<Integer, Integer, Integer> areaOfRectangle = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer length, Integer breadth) {
                return length * breadth;
            }
        };
        System.out.println("Rectangle area: " + areaOfRectangle.apply(4, 5));

        BiFunction<Integer, Integer, Integer> areaOfRectangleLambda = (length, breadth) -> length * breadth;
        System.out.println("Rectangle area(lambda): " + areaOfRectangle.apply(5, 6));

        int volume = areaOfRectangleLambda
                .andThen((area) -> area * 10)
                .apply(4, 5);
        System.out.println("Rectangle volume(lambda): " + volume);
    }

    private static void fi_predicate() {
        System.out.println("*********** fi_consumer ***********");
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number%2 == 0;
            }
        };
        System.out.println("FI number test is: " + isEven.test(25));

        Predicate<Integer> isEvenLambda = (number) -> number%2 == 0;
        System.out.println("Lambda number test is: " + isEvenLambda.test(50));

        boolean flag = isEvenLambda
                            .and(n -> n < 10)
                            .and(n -> n > 5)
                            .test(6);
        System.out.println("Composition lambda test is: " + flag);
    }

}
