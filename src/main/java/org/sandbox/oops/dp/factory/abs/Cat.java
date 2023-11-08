package org.sandbox.oops.dp.factory.abs;

public class Cat implements Pet {
    @Override
    public void eat(String food) {
        System.out.println("Cat eats " + food);
    }
}
