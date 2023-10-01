package org.selfstudy.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumbers {

    public static void main(String[] args) {

        final var arr = new int[]{2, 1, 4, 3, 8, 5, 9};
        final var sum = 10;

        final var start1 = System.nanoTime();
        System.out.println(Arrays.toString(findTwoNumbers(arr, sum)));
        final var end1 = System.nanoTime();
        System.out.println(end1 - start1);

        final var start2 = System.nanoTime();
        System.out.println(Arrays.toString(findTwoNumbersByMap(arr, 10)));
        final var end2 = System.nanoTime();
        System.out.println(end2 - start2);

        final var arr1 = new int[]{2, 1, 4, 5, 8, 5, 9, 1};
        System.out.println(Arrays.toString(findTwoNextNumbers(arr1, sum)));
    }

    public static int[] findTwoNumbers(int[] inputArr, int targetSum) {

        if (inputArr == null || inputArr.length < 2) {
            throw new RuntimeException("Input array must contain not less than 2 numbers");
        }

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[i] + inputArr[j] == targetSum) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public static int[] findTwoNumbersByMap(int[] inputArr, int targetSum) {
        final var map = new HashMap<Integer, Integer>(inputArr.length);

        for (int i = 0; i < inputArr.length; i++) {
            if (map.containsKey(inputArr[i])) {
                return new int[]{map.get(inputArr[i]), i};
            }
            map.put(targetSum - inputArr[i], i);
        }

        return new int[2];
    }

    public static int[] findTwoNextNumbers(int[] inputArr, int targetSum) {

        if (inputArr == null || inputArr.length < 2) {
            throw new RuntimeException("Input array must contain not less than 2 numbers");
        }

        final var resultArr = new int[2];

        for (int i = 0; i < inputArr.length - 1; i++) {
            if (inputArr[i] + inputArr[i + 1] == targetSum) {
                return new int[]{i, i + 1};
            }
        }

        return resultArr;
    }
}
