package org.sandbox.dsa.ds.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImpl implements ILRUCache {
    // Hash map to store the cache data
    Map<Integer, String> map;
    // Linked list to store the order of cache access
    LinkedList<Integer> order = new LinkedList<>();

    int capacity;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    @Override
    public void put(Integer key, String value) {
        if (order.size() >= capacity) {
            Integer lruKey = order.removeLast();
            map.remove(lruKey);
        }

        if (order.contains(key)) {
            order.remove(key);
        }

        order.addFirst(key);
        map.put(key, value);

    }

    @Override
    public String get(Integer key) {
        String data = map.get(key);
        if (data != null) {
            order.remove(key);
            order.addFirst(key);
        }
        return data;
    }

    public void printAll() {
        System.out.println("===== Cache =====");
        for (Integer key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    public static void main(String[] args) {
        ILRUCache cache = new LRUCacheImpl(3);

        cache.put(5, "A");
        cache.put(4, "B");
        cache.put(3, "C");

        cache.get(5);

        cache.printAll();

        cache.put(5, "D");
        cache.put(1, "F");

        cache.printAll();
    }
}
