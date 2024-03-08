package org.sandbox.pattern.singleton;

// Double Checked Locking Pattern
public class DoubleCheckedLockingSingleton {

    // To avoid cache incoherence issue in multithreaded env
    private static volatile DoubleCheckedLockingSingleton _instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (_instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (_instance == null) {
                    _instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return _instance;
    }

}
