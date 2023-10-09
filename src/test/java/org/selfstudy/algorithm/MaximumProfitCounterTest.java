package org.selfstudy.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumProfitCounterTest {

    @Test
    void countMaximumProfitSimple() {
        final var maximumProfitCounter = new MaximumProfitCounter();
        final var arr0 = new Integer[]{4, 1, 2, 3};
        final var maximumProfit0 = maximumProfitCounter.countMaximumProfit(arr0);
        Assertions.assertEquals(6, maximumProfit0);
    }

    @Test
    void countMaximumProfitLongArr() {
        final var maximumProfitCounter = new MaximumProfitCounter();
        final var arr = new Integer[]{1, 2, 3, 3, 2, 1, 5};
        final var maximumProfit = maximumProfitCounter.countMaximumProfit(arr);
        Assertions.assertEquals(7, maximumProfit);
    }

    @Test
    void countMaximumProfitLongArr1() {
        final var maximumProfitCounter = new MaximumProfitCounter();
        final var arr = new Integer[]{1, 2, 3, 3, 2, 1, 3, 5, 3};
        final var maximumProfit = maximumProfitCounter.countMaximumProfit(arr);
        Assertions.assertEquals(7, maximumProfit);
    }

    @Test
    void countMaximumProfitBigValues() {
        final var maximumProfitCounter = new MaximumProfitCounter();
        final var arr = new Integer[]{1000000000, 1, 2, 2, 1000000000, 1, 1000000000};//2999999998
        final var maximumProfit = maximumProfitCounter.countMaximumProfit(arr);
        Assertions.assertEquals(999999998, maximumProfit);
    }

    @Test
    void countMaximumProfitLongArr2() {
        final var maximumProfitCounter = new MaximumProfitCounter();
        final var arr = new Integer[]{3, 2, 4, 1, 0, 4, 5, 3, 6, 0, 98, 0, 123};
        final var maximumProfit = maximumProfitCounter.countMaximumProfit(arr);
        Assertions.assertEquals(234, maximumProfit);
    }
}