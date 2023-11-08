package org.sandbox.fp.utils;

@FunctionalInterface
public interface StringProcessor {
    String process(String input);

    default String lowerCase(String input) {
        return input.toLowerCase();
    }

    static String upperCase(String input) {
        return input.toUpperCase();
    }
}
