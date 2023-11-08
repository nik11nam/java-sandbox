package org.sandbox.oops.dp.factory.abs;

public class FactoryProducer {

    public static AbstractFactory getFactory(String factory) {
        if (factory.equalsIgnoreCase("human")) {
            return new HumanFactory();
        } else if (factory.equalsIgnoreCase("pet")) {
            return new PetFactory();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstractFactory humanFactory = FactoryProducer.getFactory("Human");
        AbstractFactory petFactory = FactoryProducer.getFactory("Pet");

        Human human = humanFactory.getHuman("kid");
        human.feed("cat");

        Pet pet = petFactory.getPet("cat");
        pet.eat("meat");

    }
}
