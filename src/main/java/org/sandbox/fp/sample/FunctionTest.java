package org.sandbox.fp.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<String, Integer> func1 = (x) -> Integer.parseInt(x);
        System.out.println(func1.apply("10"));

        Function<Integer, String> func2 = (x) -> String.valueOf(x);
        Function<String, Integer> func3 = (x) -> Integer.parseInt(x);
        System.out.println(func2.apply(12));
        System.out.println(func3.apply("15"));

        List<Function<String, ? extends Number>> list = new ArrayList<>();
        list.add(str -> Byte.parseByte(str));
        list.add(str -> Short.parseShort(str));
        list.add(str -> Integer.parseInt(str));
        list.add(str -> Long.parseLong(str));
        list.add(str -> Float.parseFloat(str));
        list.add(str -> Double.parseDouble(str));

        List<String> stringList = Arrays.asList("10", "20", "30", "40", "50", "60");
        for (int i=0; i<stringList.size(); i++) {
            System.out.println((list.get(i)).apply(stringList.get(i)));
        }

    }

    private static <T, R> R transform(T t, Function<T, R> func) {
        return func.apply(t);
    }

    private static <R extends Number> R parse(String s, Function<String, R> func) {
        return func.apply(s);
    }

}
