package org.sandbox.oops.dp.factory.abs;

public class HumanFactory extends AbstractFactory {

    @Override
    public Pet getPet(String pet) {
        // don't implement
        return null;
    }

    public Human getHuman(String human)  {
        if (human == null) return null;

        if (human.equalsIgnoreCase("adult")) {
            return new Adult();
        } else if (human.equalsIgnoreCase("kid")) {
            return new Kid();
        }
        return null;
    }
}
