package org.sandbox.oops.dp.factory.abs;

public class Dog implements Pet {
    @Override
    public void eat(String food) {
        System.out.println("Dog eats " + food);
    }
}
