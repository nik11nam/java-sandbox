package org.sandbox.pattern.singleton;

// Double Checked Locking Pattern
public class CourseRegistry {

    // To avoid cache incoherence issue in multithreaded env
    private static volatile CourseRegistry _instance;

    private CourseRegistry() {}

    public static CourseRegistry getInstance() {
        if (_instance == null) {
            synchronized (CourseRegistry.class) {
                if (_instance == null) {
                    _instance = new CourseRegistry();
                }
            }
        }
        return _instance;
    }

}
