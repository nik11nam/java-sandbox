package org.sandbox.fp.lambda;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
