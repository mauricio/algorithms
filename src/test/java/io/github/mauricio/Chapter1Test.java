package io.github.mauricio;

import static org.junit.Assert.*;
import static io.github.mauricio.Chapter1.*;
import org.junit.Test;

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
        urlifyMatch("Foo Bar  ",7, "Foo%20Bar");
        urlifyMatch("Nothing Else Matters Here      ", 25, "Nothing%20Else%20Matters%20Here");
    }

    public void urlifyMatch(String input, int length, String result) {
        var c = input.toCharArray();
        urlify(c, length);
        assertEquals(result, new String(c));
    }


}
