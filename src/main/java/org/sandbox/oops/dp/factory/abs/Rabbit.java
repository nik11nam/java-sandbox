package org.sandbox.oops.dp.factory.abs;

public class Rabbit implements Pet {
    @Override
    public void eat(String food) {
        System.out.println("Rabbit eats " + food);
    }

}
