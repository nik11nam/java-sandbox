package org.sandbox.oops.dp.factory.abs;

public class Adult implements Human{
    @Override
    public void feed(String pet) {
        System.out.println("Adult feeds " + pet);
    }
}
