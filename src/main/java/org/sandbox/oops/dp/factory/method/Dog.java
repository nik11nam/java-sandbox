package org.sandbox.oops.dp.factory.method;

public class Dog implements Pet {
    @Override
    public void eat(String food) {
        System.out.println("Dog eats " + food);
    }
}
