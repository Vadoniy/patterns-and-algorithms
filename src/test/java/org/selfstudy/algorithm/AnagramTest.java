package org.selfstudy.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagramByArrays() {
        final var anagram = new Anagram();
        final var start = System.nanoTime();
        Assertions.assertTrue(anagram.isAnagramByArrays("ФАРА", "АРФА"));
        Assertions.assertTrue(anagram.isAnagramByArrays("КОМАР", "РАКОМ"));
        Assertions.assertTrue(anagram.isAnagramByArrays("", ""));
        Assertions.assertTrue(anagram.isAnagramByArrays(null, null));
        Assertions.assertFalse(anagram.isAnagramByArrays("БУЛКА", "ВИЛКА"));
        Assertions.assertFalse(anagram.isAnagramByArrays("БУЛКА", "БУЛОЧКА"));
        Assertions.assertFalse(anagram.isAnagramByArrays("БУЛКА", null));
        final var end = System.nanoTime();
        System.out.println("isAnagramByArrays time is "+ (end - start));
    }

    @Test
    void isAnagramByMap() {
        final var anagram = new Anagram();
        final var start = System.nanoTime();
        Assertions.assertTrue(anagram.isAnagramByMap("ФАРА", "АРФА"));
        Assertions.assertTrue(anagram.isAnagramByMap("КОМАР", "РАКОМ"));
        Assertions.assertTrue(anagram.isAnagramByMap("", ""));
        Assertions.assertTrue(anagram.isAnagramByMap(null, null));
        Assertions.assertFalse(anagram.isAnagramByMap("БУЛКА", "ВИЛКА"));
        Assertions.assertFalse(anagram.isAnagramByMap("БУЛКА", "БУЛОЧКА"));
        Assertions.assertFalse(anagram.isAnagramByMap("БУЛКА", null));
        final var end = System.nanoTime();
        System.out.println("isAnagramByMap time is "+ (end - start));
    }
}