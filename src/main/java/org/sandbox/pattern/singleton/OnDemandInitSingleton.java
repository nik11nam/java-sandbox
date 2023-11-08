package org.sandbox.pattern.singleton;

public class OnDemandInitSingleton {

    private static class InstanceHolder {
         private static final OnDemandInitSingleton _instance = new OnDemandInitSingleton();
    }

    private OnDemandInitSingleton() { }

    public static OnDemandInitSingleton getInstance() {
        return InstanceHolder._instance;
    }

}
