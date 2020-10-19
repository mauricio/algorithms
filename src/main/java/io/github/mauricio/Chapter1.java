package io.github.mauricio;

import java.util.*;

public class Chapter1 {

    public static boolean isUniqueHash(String s) {
        var chars = new HashMap<Character, Boolean>();

        for (int x = 0; x < s.length(); x++) {
            var c = s.charAt(x);
            if (chars.putIfAbsent(c, true) != null) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUnique(String s) {
        var r = s.toCharArray();
        Arrays.sort(r);

        Character last = null;
        for (var x = 0; x < s.length(); x++) {
            var c = Character.valueOf(r[x]);
            if (c.equals(last)) {
                return false;
            }
            last = c;
        }

        return true;
    }

    public static void urlify(char[] characters, int length) {
        var spaces = 0;
        for (var x = 0; x < length; x++) {
            if (characters[x] == ' ') {
                spaces++;
            }
        }

        if (spaces == 0) {
            return;
        }

        var shift = spaces * 2;

        for (var x = length - 1; x >= 0; x--) {
            switch (characters[x]) {
                case ' ':
                    characters[x + shift - 2] = '%';
                    characters[x + shift - 1] = '2';
                    characters[x + shift] = '0';
                    spaces--;
                    shift = spaces * 2;
                    if (shift == 0) {
                        return;
                    }
                    break;
                default:
                    characters[x + shift] = characters[x];
            }
        }
    }

    public static boolean isPermutation(String left, String right) {
        return letterFrequency(left).equals(letterFrequency(right));
    }

    public static Map<Character, Integer> letterFrequency(String s) {
        var result = new HashMap<Character, Integer>();

        for (var c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                result.compute(c, (character, integer) -> {
                    if (integer == null) {
                        integer = 0;
                    }

                    return integer + 1;
                });
            }
        }

        return result;
    }

    public static boolean isPalindrome(String s) {
        var odds = 0;

        for (var entry : letterFrequency(s).entrySet()) {
            if ((entry.getValue() % 2) != 0) {
                odds++;
            }

            if (odds > 1) {
                return false;
            }

        }

        return true;
    }

    public static boolean isOneAway(String received, String expected) {
        var differences = 0;

        if (received.equals(expected)) {
            return true;
        }

        if (received.length() == expected.length()) {
            for (var x = 0; x < received.length(); x++) {
                if (received.charAt(x) != expected.charAt(x)) {
                    differences++;
                }
                if (differences > 1) {
                    return false;
                }
            }
            return true;
        }

        var max = received;
        var min = expected;
        if (received.length() < expected.length()) {
            max = expected;
            min = received;
        }

        for (var x = 0; x < max.length() && differences <= 1;x++) {
            if (x >= min.length()) {
                differences++;
            } else if (max.charAt(x) != min.charAt(x) && max.substring(x + 1, min.length()).equals(min.substring(x))) {
                differences++;
            }
        }

        return differences <= 1;
    }

}
