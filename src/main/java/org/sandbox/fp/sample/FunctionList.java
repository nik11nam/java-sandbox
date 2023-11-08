package org.sandbox.fp.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionList {

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T str : list) {
            newList.add(function.apply(str));
        }
        return newList;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World", "Welcome", "Home");

        Function<String, Integer> lengthLambda = (str) -> str.length();
        List<Integer> strLength = map(list, lengthLambda);

        strLength.stream().forEach(System.out::println);
    }

}
