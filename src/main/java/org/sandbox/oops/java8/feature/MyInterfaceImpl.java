package org.sandbox.oops.java8.feature;

/**
 * https://stackoverflow.com/questions/27833168/difference-between-static-and-default-methods-in-interface
 *
 * Java 8 features --> https://www.softwaretestinghelp.com/java/prominent-java-8-features/
 */
public class MyInterfaceImpl implements MyInterface {

    @Override
    public void someMethod1() {
        System.out.println("MyInterfaceImpl::someMethod1");
    }

    static void someMethod2() {
        System.out.println("MyInterfaceImpl::someMethod2");
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.someMethod1();

        MyInterface.someMethod2();
        MyInterfaceImpl.someMethod2();
    }

}

interface MyInterface {

    default void someMethod1() {
        System.out.println("MyInterface::someMethod1");
    }

    static void someMethod2() {
        System.out.println("MyInterface::someMethod1");
    }

}


