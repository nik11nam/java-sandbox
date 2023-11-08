package org.sandbox.oops.dp.singleton;

/**
 * Double checked locking singleton
 * https://javarevisited.blogspot.com/2014/05/double-checked-locking-on-singleton-in-java.html
 * ********************************
 * lazy loaded thread-safe Singleton
 * ********************************
 */
public class DoubleCheckedLockingSingleton {

    private volatile DoubleCheckedLockingSingleton INSTANCE;

    private DoubleCheckedLockingSingleton(){}

    public DoubleCheckedLockingSingleton getInstance(){
        if(INSTANCE == null){
            synchronized(DoubleCheckedLockingSingleton.class){
                //double checking Singleton instance
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
