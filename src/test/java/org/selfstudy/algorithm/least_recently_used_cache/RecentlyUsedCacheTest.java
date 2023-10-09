package org.selfstudy.algorithm.least_recently_used_cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecentlyUsedCacheTest {

    private RecentlyUsedCache recentlyUsedCache;

    @Test
    void get() {
        recentlyUsedCache = new RecentlyUsedCache(2);
        recentlyUsedCache.put(1, 1);
        Assertions.assertEquals(recentlyUsedCache.get(1), 1);
        recentlyUsedCache.put(2, 2);
        recentlyUsedCache.get(1);
        recentlyUsedCache.put(3, 3);
        Assertions.assertEquals(recentlyUsedCache.get(1), 1);
        Assertions.assertEquals(recentlyUsedCache.get(2), -1);
        Assertions.assertEquals(recentlyUsedCache.get(3), 3);

    }

    @Test
    void put1() {
        recentlyUsedCache = new RecentlyUsedCache(5);
        recentlyUsedCache.put(1, 1);
        recentlyUsedCache.put(2, 2);
        recentlyUsedCache.put(3, 3);
        recentlyUsedCache.put(4, 4);
        recentlyUsedCache.put(5, 5);
        Assertions.assertEquals(1, recentlyUsedCache.get(1));
        Assertions.assertEquals(2, recentlyUsedCache.get(2));
        Assertions.assertEquals(3, recentlyUsedCache.get(3));
        Assertions.assertEquals(4, recentlyUsedCache.get(4));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        recentlyUsedCache.put(6, 6);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(2, recentlyUsedCache.get(2));
        Assertions.assertEquals(3, recentlyUsedCache.get(3));
        Assertions.assertEquals(4, recentlyUsedCache.get(4));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        Assertions.assertEquals(6, recentlyUsedCache.get(6));
        recentlyUsedCache.put(7, 7);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(-1, recentlyUsedCache.get(2));
        Assertions.assertEquals(3, recentlyUsedCache.get(3));
        Assertions.assertEquals(4, recentlyUsedCache.get(4));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        Assertions.assertEquals(6, recentlyUsedCache.get(6));
        Assertions.assertEquals(7, recentlyUsedCache.get(7));
        recentlyUsedCache.put(8, 8);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(-1, recentlyUsedCache.get(2));
        Assertions.assertEquals(-1, recentlyUsedCache.get(3));
        Assertions.assertEquals(4, recentlyUsedCache.get(4));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        Assertions.assertEquals(6, recentlyUsedCache.get(6));
        Assertions.assertEquals(7, recentlyUsedCache.get(7));
        Assertions.assertEquals(8, recentlyUsedCache.get(8));
        recentlyUsedCache.put(9, 9);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(-1, recentlyUsedCache.get(2));
        Assertions.assertEquals(-1, recentlyUsedCache.get(3));
        Assertions.assertEquals(-1, recentlyUsedCache.get(4));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        Assertions.assertEquals(6, recentlyUsedCache.get(6));
        Assertions.assertEquals(7, recentlyUsedCache.get(7));
        Assertions.assertEquals(8, recentlyUsedCache.get(8));
        Assertions.assertEquals(9, recentlyUsedCache.get(9));
        recentlyUsedCache.put(10, 10);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(-1, recentlyUsedCache.get(2));
        Assertions.assertEquals(-1, recentlyUsedCache.get(3));
        Assertions.assertEquals(-1, recentlyUsedCache.get(4));
        Assertions.assertEquals(-1, recentlyUsedCache.get(5));
        Assertions.assertEquals(6, recentlyUsedCache.get(6));
        Assertions.assertEquals(7, recentlyUsedCache.get(7));
        Assertions.assertEquals(8, recentlyUsedCache.get(8));
        Assertions.assertEquals(9, recentlyUsedCache.get(9));
        Assertions.assertEquals(10, recentlyUsedCache.get(10));
        recentlyUsedCache.put(7, 77);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(-1, recentlyUsedCache.get(2));
        Assertions.assertEquals(-1, recentlyUsedCache.get(3));
        Assertions.assertEquals(-1, recentlyUsedCache.get(4));
        Assertions.assertEquals(-1, recentlyUsedCache.get(5));
        Assertions.assertEquals(6, recentlyUsedCache.get(6));
        Assertions.assertEquals(77, recentlyUsedCache.get(7));
        Assertions.assertEquals(8, recentlyUsedCache.get(8));
        Assertions.assertEquals(9, recentlyUsedCache.get(9));
        Assertions.assertEquals(10, recentlyUsedCache.get(10));
        recentlyUsedCache.get(6);
        recentlyUsedCache.put(99, 88);
        Assertions.assertEquals(-1, recentlyUsedCache.get(7));
        Assertions.assertEquals(88, recentlyUsedCache.get(99));
    }

    @Test
    void put2() {
        recentlyUsedCache = new RecentlyUsedCache(2);
        recentlyUsedCache.put(1, 1);
        Assertions.assertEquals(1, recentlyUsedCache.get(1));
        recentlyUsedCache.put(2, 2);
        Assertions.assertEquals(1, recentlyUsedCache.get(1));
        Assertions.assertEquals(2, recentlyUsedCache.get(2));
        recentlyUsedCache.put(3, 3);
        Assertions.assertEquals(2, recentlyUsedCache.get(2));
        Assertions.assertEquals(3, recentlyUsedCache.get(3));
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
    }
}