package org.selfstudy.algorithm.least_recently_used_cache;

public interface LRUCache {

    int get(int key);

    void put(int key, int value);
}
