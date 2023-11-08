package org.sandbox.dsa.ds.cache;

public interface ILRUCache {

    void put(Integer key, String value);

    String get(Integer key);

    void printAll();
}
