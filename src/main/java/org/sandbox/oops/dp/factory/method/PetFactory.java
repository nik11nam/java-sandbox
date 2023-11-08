package org.sandbox.oops.dp.factory.method;

/**
 * https://stackabuse.com/creational-design-patterns-in-java/#abstractfactory
 */
public class PetFactory {

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

    public static void main(String[] args) {
        PetFactory factory = new PetFactory();

        Pet pet1 = factory.getPet("cat");
        pet1.eat("chicken");

        Pet pet2 = factory.getPet("RABBIT");
        pet2.eat("grass");
    }

}
