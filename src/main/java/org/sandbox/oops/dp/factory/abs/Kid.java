package org.sandbox.oops.dp.factory.abs;

public class Kid implements Human {
    @Override
    public void feed(String pet) {
        System.out.println("Kid feeds " + pet);
    }
}
