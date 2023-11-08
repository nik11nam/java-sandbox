package org.sandbox.oops.dp.singleton;

/**
 * Singleton pattern example using Java Enum
 * By default creation of Enum instance is thread safe but any other method on Enum is programmers responsibility
 *
 * https://dzone.com/articles/java-singletons-using-enum
 */
public enum EasySingleton {
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
