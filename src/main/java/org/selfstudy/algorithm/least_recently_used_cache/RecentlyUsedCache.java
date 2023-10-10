package org.selfstudy.algorithm.least_recently_used_cache;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
 * the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key
 * (the key that has not been get/put for the longest time).
 * Bonus: The functions get and put must each run in O(1) average time complexity.
 * Examples:
 * LRUCache lRUCache = new LRUCache(2); //init with capacity 2
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.put(3, 3); // invalidate key 2, so cache becomes {1=1, 3=3}
 * lRUCache.get(2); // return -1 (not found)
 * lRUCache.put(4, 4); // invalidate key 1, so cache becomes {4=4, 3=3}
 * lRUCache.get(1); // return -1 (not found)
 * lRUCache.get(3); // return 3
 * lRUCache.get(4); // return 4
 */

public class RecentlyUsedCache implements LRUCache {

    int capacity;
    Map<Integer, Integer> map;
    LinkedList<Integer> order;

    public RecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.order = new LinkedList<>();
    }

    @Override
    public int get(int key) {
        if (map.containsKey(key)) {
            order.remove(Integer.valueOf(key));
            order.addLast(key);
            return map.get(key);
        }

        return -1;
    }

    @Override
    public void put(int key, int value) {
        if (Optional.ofNullable(map.get(key)).orElse(-1) == -1 && map.size() == capacity) { //get() invocation in necessary to refresh "order"
            int first = order.removeFirst();
            map.remove(first);
        } else if (!order.isEmpty() && order.getFirst().equals(key)) {
            order.removeFirst();
        }
        order.addLast(key);
        map.put(key, value);
    }
}
