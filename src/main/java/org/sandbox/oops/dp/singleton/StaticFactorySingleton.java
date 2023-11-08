package org.sandbox.oops.dp.singleton;

/**
 * Singleton pattern example with static factory method
 * Since Singleton instance is static and final variable it initialized when class is first loaded
 * into memory so creation of instance is inherently thread-safe.
 */
public class StaticFactorySingleton {

    //initialized during class loading
    private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();

    //to prevent creating another instance of Singleton
    private StaticFactorySingleton(){}

    public static StaticFactorySingleton getSingleton(){
        return INSTANCE;
    }

}
