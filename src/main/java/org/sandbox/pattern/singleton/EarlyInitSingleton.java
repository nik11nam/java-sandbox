package org.sandbox.pattern.singleton;

public class EarlyInitSingleton {

    private static final EarlyInitSingleton _instance = new EarlyInitSingleton();

    private EarlyInitSingleton() { }

    public static EarlyInitSingleton getInstance() {
        return _instance;
    }

}
