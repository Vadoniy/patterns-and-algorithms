package org.selfstudy.algorithm;

import java.math.BigDecimal;

/**
 * You are given a record of the historical prices of an investment asset from the last N days. Analyze the record in
 * order to calculate what could have been your maximum income. Assume you started with one asset of this type and could
 * hold at most one at a time. You could choose to sell the asset whenever you held one. If you did not hold an asset at
 * some moment, you could always afford to buy an asset(assume you had infinite money available). What is the maximum
 * income you could make?
 * <p>
 * Write a function in Java 8 or 11
 * public int solution (int[] A);
 * that, given an array A of length N representing a record of prices over the last N days, returns the maximum income
 * you could make.
 * <p>
 * Example 1 - Given A= [4,1,2,3], the function should return 6. You could sell the product on the first day (for 4),
 * buy it on the second (for 1) and sell it again on the last day (for 3). The income would be equal to 4-1+3 = 6
 * <p>
 * Example 2 - Given A= [1,2,3,3,2,1,5], the function should return 7. You could sell the product when its value was 3,
 * buy it when it changed to 1, and sell it again when it was worth 5.
 * <p>
 * 3. Given A = [1000000000, 1, 2, 2, 1000000000, 1, 1000000000], the function
 * should return 999999998. The maximum possible income is 2999999998, whose last 9 digits are 999999998.
 * <p>
 */
public class MaximumProfitCounter {

    public int countMaximumProfit(Integer[] prices) {
        var isAsset = true;
        var maxProfit = BigDecimal.ZERO;

        for (int i = 0; i < prices.length - 1; i++) {
            if (isAsset) {
                if (prices[i] > prices[i + 1]) {
                    maxProfit = maxProfit.add(new BigDecimal(prices[i]));
                    isAsset = false;
                }
            } else {
                if (prices[i] < prices[i + 1]) {
                    maxProfit = maxProfit.subtract(new BigDecimal(prices[i]));
                    isAsset = true;
                }
            }
        }

        if (isAsset) {
            maxProfit = maxProfit.add(new BigDecimal(prices[prices.length - 1]));
        }
        return cutTheResult(maxProfit);
    }

    //TODO refactor this cutting method
    private int cutTheResult(BigDecimal maxProfit) {
        if (maxProfit.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            final var withFractionalPart = maxProfit.divide(new BigDecimal(1_000_000_000));
            final var fractionalPart = withFractionalPart.remainder(BigDecimal.ONE)
                    .scaleByPowerOfTen(withFractionalPart.scale());
            return fractionalPart.intValueExact();
        }
        return maxProfit.intValue();
    }
}
