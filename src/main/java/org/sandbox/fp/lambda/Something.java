package org.sandbox.fp.lambda;

public class Something {
    public String startsWith(String s) {
        return s.substring(0, 1);
    }

    public static void main(String[] args) {
        Converter<String, Integer> converter1 = (from) -> Integer.valueOf(from);
        Integer value = converter1.convert("123");
        System.out.println(value);

        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted = converter2.convert("123");
        System.out.println(converted);

        Something something = new Something();
        Converter<String, String> converter3 = something::startsWith;
        System.out.println(converter3.convert("123"));
    }
}
