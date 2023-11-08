package org.sandbox.fp.sample;

import org.sandbox.fp.utils.StringProcessor;

public class StringProcessorMain {

    public static void main(String[] args) {
        StringProcessor toLowerCase = str -> str.toLowerCase();
        StringProcessor concatStr = str -> str.concat("World");

        System.out.println(toLowerCase.process("Hello World"));
        System.out.println(concatStr.process("Hello "));

        System.out.println(toLowerCase.lowerCase("Hello World"));
        System.out.println(StringProcessor.upperCase("Hello World"));
    }

}
