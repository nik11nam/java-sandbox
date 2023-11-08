package org.sandbox.fp.lambda;

// Method and Constructor Reference (Double colon operator -> ::)
public class MethodReferenceExample {

    private String s;

    public MethodReferenceExample(String s) {
        this.s = s;
        System.out.println("Constructor print show: " + s);
    }

    public void print(String s) {
        System.out.println("Method print show: " + s);
    }

    public static void staticPrint(String s) {
        System.out.println("Static method print show: " + s);
    }

    public static void main(String[] args) {
        // Constructor reference
        ExampleInterface constructorReference = MethodReferenceExample::new;
        constructorReference.show("Hello");

        // Instance method reference
        MethodReferenceExample methodReferenceExample = new MethodReferenceExample("World");
        ExampleInterface methodReference = methodReferenceExample::print;
        methodReference.show("Hello");

        // Static method reference
        ExampleInterface staticMethodReference = MethodReferenceExample::staticPrint;
        staticMethodReference.show("Hello");
    }
}
