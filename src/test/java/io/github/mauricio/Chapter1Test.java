package io.github.mauricio;

import static org.junit.Assert.*;
import static io.github.mauricio.Chapter1.*;

import org.junit.Test;

import java.util.Arrays;

public class Chapter1Test {

    @Test
    public void testIsUnique() {
        isUniqueMatch("abcde", true);
        isUniqueMatch("mama", false);
        isUniqueMatch("papa", false);
        isUniqueMatch("daileon", true);
        isUniqueMatch("king", true);
    }

    public void isUniqueMatch(String s, boolean result) {
        assertEquals(isUnique(s), result);
        assertEquals(isUniqueHash(s), result);
    }

    @Test
    public void testUrlify() {
        urlifyMatch("Mr John Smith    ", 13, "Mr%20John%20Smith");
        urlifyMatch("Foo Bar  ", 7, "Foo%20Bar");
        urlifyMatch("Nothing Else Matters Here      ", 25, "Nothing%20Else%20Matters%20Here");
    }

    public void urlifyMatch(String input, int length, String result) {
        var c = input.toCharArray();
        urlify(c, length);
        assertEquals(result, new String(c));
    }

    @Test
    public void testIsPermutation() {
        assertTrue(isPermutation("dog", "god"));
        assertTrue(isPermutation("taco bell", "lleb ocat"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(isPalindrome("Tact Coa"));
    }

    @Test
    public void testIsOneAway() {
        assertTrue(isOneAway("pug", "pugb"));
        assertTrue(isOneAway("inland", "finland"));
        assertTrue(isOneAway("brazil", "brazi"));
        assertTrue(isOneAway("bale", "pale"));
        assertFalse(isOneAway("england", "finland"));
    }

    @Test
    public void testCompress() {
        assertEquals("a2b1c4a3", compress("aabccccaaa"));
        assertEquals("abcdef", compress("abcdef"));
    }

    @Test
    public void testRotate90() {
        var input = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
        };

        var expected = new int[][]{
                new int[]{4, 1},
                new int[]{5, 2},
                new int[]{6, 3},
        };

        assertTrue(Arrays.deepEquals(expected, rotate90(input)));
    }

}
