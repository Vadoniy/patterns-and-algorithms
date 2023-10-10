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

    @Test
    void put3() {
        recentlyUsedCache = new RecentlyUsedCache(2);
        recentlyUsedCache.put(2, 1);
        recentlyUsedCache.put(1, 1);
        recentlyUsedCache.put(2, 3);
        recentlyUsedCache.put(4, 1);
        Assertions.assertEquals(-1, recentlyUsedCache.get(1));
        Assertions.assertEquals(3, recentlyUsedCache.get(2));
    }

    @Test
    void put4() {
        recentlyUsedCache = new RecentlyUsedCache(10);
        recentlyUsedCache.put(10, 13);
        recentlyUsedCache.put(3, 17);
        recentlyUsedCache.put(6, 11);
        recentlyUsedCache.put(10, 5);
        recentlyUsedCache.put(9, 10);
        Assertions.assertEquals(-1, recentlyUsedCache.get(13));
        recentlyUsedCache.put(2, 19);
        Assertions.assertEquals(19, recentlyUsedCache.get(2));
        Assertions.assertEquals(17, recentlyUsedCache.get(3));
        recentlyUsedCache.put(5, 25);
        Assertions.assertEquals(-1, recentlyUsedCache.get(8));
        recentlyUsedCache.put(9, 22);
        recentlyUsedCache.put(5, 5);
        recentlyUsedCache.put(1, 30);
        Assertions.assertEquals(-1, recentlyUsedCache.get(11));
        recentlyUsedCache.put(9, 12);
        Assertions.assertEquals(-1, recentlyUsedCache.get(7));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        Assertions.assertEquals(-1, recentlyUsedCache.get(8));
        Assertions.assertEquals(12, recentlyUsedCache.get(9));
        recentlyUsedCache.put(4, 30);
        recentlyUsedCache.put(9, 3);
        Assertions.assertEquals(3, recentlyUsedCache.get(9));
        Assertions.assertEquals(5, recentlyUsedCache.get(10));
        Assertions.assertEquals(5, recentlyUsedCache.get(10));
        recentlyUsedCache.put(6, 14);
        recentlyUsedCache.put(3, 1);
        Assertions.assertEquals(1, recentlyUsedCache.get(3));
        recentlyUsedCache.put(10, 11);
        Assertions.assertEquals(-1, recentlyUsedCache.get(8));
        recentlyUsedCache.put(2, 14);
        Assertions.assertEquals(30, recentlyUsedCache.get(1));
        Assertions.assertEquals(5, recentlyUsedCache.get(5));
        Assertions.assertEquals(30, recentlyUsedCache.get(4));
        recentlyUsedCache.put(11, 4);
        recentlyUsedCache.put(12, 24);
        recentlyUsedCache.put(5, 18);
        Assertions.assertEquals(-1, recentlyUsedCache.get(13));
        recentlyUsedCache.put(7, 23);
        Assertions.assertEquals(-1, recentlyUsedCache.get(8));
        Assertions.assertEquals(24, recentlyUsedCache.get(12));
        recentlyUsedCache.put(3, 27);
        recentlyUsedCache.put(2, 12);
        Assertions.assertEquals(18, recentlyUsedCache.get(5));
        recentlyUsedCache.put(2, 9);
        recentlyUsedCache.put(13, 4);
        recentlyUsedCache.put(8, 18);
        recentlyUsedCache.put(1, 7);
        Assertions.assertEquals(14, recentlyUsedCache.get(6));
        recentlyUsedCache.put(9, 29);
        recentlyUsedCache.put(8, 21);
        Assertions.assertEquals(18, recentlyUsedCache.get(5));
        recentlyUsedCache.put(6, 30);
        recentlyUsedCache.put(1, 12);
        Assertions.assertEquals(11, recentlyUsedCache.get(10));
        recentlyUsedCache.put(4, 15);
        recentlyUsedCache.put(7, 22);
        recentlyUsedCache.put(11, 26);
        recentlyUsedCache.put(8, 17);
        recentlyUsedCache.put(9, 29);
        Assertions.assertEquals(18, recentlyUsedCache.get(5));
        recentlyUsedCache.put(3, 4);
        recentlyUsedCache.put(11, 30);
        Assertions.assertEquals(24, recentlyUsedCache.get(12));
        recentlyUsedCache.put(4, 29);
        Assertions.assertEquals(4, recentlyUsedCache.get(3));
        Assertions.assertEquals(29, recentlyUsedCache.get(9));
        Assertions.assertEquals(30, recentlyUsedCache.get(6));
        recentlyUsedCache.put(3, 4);
        Assertions.assertEquals(12, recentlyUsedCache.get(1));
        Assertions.assertEquals(11, recentlyUsedCache.get(10));
        recentlyUsedCache.put(3, 29);
        recentlyUsedCache.put(10, 28);
        recentlyUsedCache.put(1, 20);
        recentlyUsedCache.put(11, 13);
        Assertions.assertEquals(29, recentlyUsedCache.get(3));
        recentlyUsedCache.put(3, 12);
        recentlyUsedCache.put(3, 8);
        recentlyUsedCache.put(10, 9);
        recentlyUsedCache.put(3, 26);
        Assertions.assertEquals(17, recentlyUsedCache.get(8));
        Assertions.assertEquals(22, recentlyUsedCache.get(7));
        Assertions.assertEquals(18, recentlyUsedCache.get(5));
        recentlyUsedCache.put(13, 17);
        recentlyUsedCache.put(2, 27);
        recentlyUsedCache.put(11, 15);
        Assertions.assertEquals(24, recentlyUsedCache.get(12));
        recentlyUsedCache.put(9, 19);
        recentlyUsedCache.put(2, 15);
        recentlyUsedCache.put(3, 16);
        Assertions.assertEquals(20, recentlyUsedCache.get(1));
        recentlyUsedCache.put(12, 17);
        recentlyUsedCache.put(9, 1);
        recentlyUsedCache.put(6, 19);
        Assertions.assertEquals(29, recentlyUsedCache.get(4));
        Assertions.assertEquals(18, recentlyUsedCache.get(5));
        Assertions.assertEquals(18, recentlyUsedCache.get(5));
        recentlyUsedCache.put(8, 1);
        recentlyUsedCache.put(11, 7);
        recentlyUsedCache.put(5, 2);
        recentlyUsedCache.put(9, 28);
        Assertions.assertEquals(20, recentlyUsedCache.get(1));
        recentlyUsedCache.put(2, 2);
        recentlyUsedCache.put(7, 4);
        recentlyUsedCache.put(4, 22);
        recentlyUsedCache.put(7, 24);
        recentlyUsedCache.put(9, 26);
        recentlyUsedCache.put(13, 28);
        recentlyUsedCache.put(11, 26);
    }
}