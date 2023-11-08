package org.sandbox.fp.sample;

import java.util.function.Predicate;

public class PredicateComposition {

    public static void main(String[] args) {
        Predicate<String> startsWith = (str) -> str.startsWith("A");
        Predicate<String> endsWith = (str) -> str.endsWith(".");

        System.out.println("AndTest: " + andTest(startsWith, endsWith));
        System.out.println("OrTest: " + orTest(startsWith, endsWith));
    }

    private static boolean andTest(Predicate<String> startsWith, Predicate endsWith) {
        final String str = "A final string.";
        return startsWith
                .and(endsWith)
                .test(str);
    }

    private static boolean orTest(Predicate<String> startsWith, Predicate endsWith) {
        final String str = "Welcome home.";
        return startsWith
                .or(endsWith)
                .test(str);
    }
}
