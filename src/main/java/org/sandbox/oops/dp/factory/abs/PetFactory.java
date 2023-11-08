package org.sandbox.oops.dp.factory.abs;

public class PetFactory extends AbstractFactory {

    public Pet getPet(String pet) {
        if (pet == null) return null;

        if (pet.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (pet.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (pet.equalsIgnoreCase("rabbit")) {
            return new Rabbit();
        }
        return null;
    }

    @Override
    public Human getHuman(String human) {
        // don't implement
        return null;
    }

}
