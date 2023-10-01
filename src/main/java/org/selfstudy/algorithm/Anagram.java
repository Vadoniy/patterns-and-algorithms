package org.selfstudy.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    public boolean isAnagramByArrays(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }

        if ((str1 == null || str2 == null) || str1.length() != str2.length()) {
            return false;
        }

        final var arr1 = str1.toCharArray();
        final var arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramByMap(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }

        if ((str1 == null || str2 == null) || str1.length() != str2.length()) {
            return false;
        }

        final var map1 = new HashMap<Character, Integer>(str1.length());

        for (int i = 0; i < str1.length(); i++) {
            map1.computeIfPresent(str1.charAt(i), (k, v) -> v + 1);
            map1.putIfAbsent(str1.charAt(i), 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            final var charAt = str2.charAt(i);
            if (map1.containsKey(charAt)) {
                if (map1.get(charAt) - 1 > 0) {
                    map1.put(charAt, map1.get(charAt) - 1);
                } else {
                    map1.remove(charAt);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
