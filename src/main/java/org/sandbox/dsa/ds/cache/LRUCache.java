package org.sandbox.dsa.ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, String> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // access-order = true, in the order of accessing the element
        // access-order = false, in the order of insertion of the element
        this.map = new LinkedHashMap<Integer, String>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return map.size() > capacity;
            }
        };
    }

    public void put(int key, String value) {
        map.put(key, value);
    }

    public String get(int key) {
        return map.get(key);
    }

    // In access-ordered linked hash maps, merely querying the map with get(k) is a structural modification
    public void printAll() {
        System.out.println("===== Cache =====");
        for (Map.Entry<Integer, String> mapElement : map.entrySet()) {
            Integer key = mapElement.getKey();
            String value = mapElement.getValue();
            System.out.println(key + " : " + value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

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
