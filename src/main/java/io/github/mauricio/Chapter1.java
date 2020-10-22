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

    public static String compress(String s) {
        if (s.length() <= 1) {
            return s;
        }

        var builder = new StringBuilder(s.length());
        var currentCharacter  = s.charAt(0);
        var count = 0;

        for (var x = 0; x < s.length(); x++) {
            var l = s.charAt(x);
            if (l == currentCharacter) {
                count++;
            } else {
                builder.append(currentCharacter);
                builder.append(count);
                currentCharacter = l;
                count = 1;
            }
        }

        builder.append(currentCharacter);
        builder.append(count);

        if (builder.length() < s.length()) {
            return builder.toString();
        }

        return s;
    }

    public static int[][] rotate90(int[][] input) {
        var rows = input.length;
        var columns = input[0].length;

        var result = new int[columns][];

        for (var x = 0; x < rows;x++) {
            for (var y = 0; y < columns;y++) {
                if (result[y] == null) {
                    result[y] = new int[rows];
                }
                result[y][rows - 1 - x] = input[x][y];
            }
        }

        return result;
    }

    public static void zeroMatrix(int[][] matrix) {
        var rows = new HashSet<Integer>();
        var columns = new HashSet<Integer>();

        for (var x = 0; x < matrix.length; x++) {
            var row  = matrix[x];
            for (var y =0; y < row.length; y++) {
                if (matrix[x][y] == 0) {
                    rows.add(x);
                    columns.add(y);
                }
                if (columns.size() == row.length) {
                    break;
                }
            }
            if (rows.size() == matrix.length) {
                break;
            }
        }

        for (var column : columns) {
            for (var row = 0; row < matrix.length; row++) {
                if (rows.contains(row)) {
                    Arrays.fill(matrix[row], 0);
                } else {
                    matrix[row][column] = 0;
                }
            }
        }
    }

    static class ShiftedString {
        private int shift;
        private String s;

        ShiftedString(String s, int shift) {
            this.s = s;
            this.shift = shift;
        }

        public char charAt(int index) {
            return this.s.charAt((index + shift) % s.length());
        }
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.equals(s2)) {
            return false;
        }

        var cutoff = s1.length()/2;
        var sub = s1.substring(0, cutoff);
        var start = s2.indexOf(sub);
        if (start != -1 ) {
            var shifted = new ShiftedString(s2, start);
            for (var x = 0; x < s1.length(); x++) {
                if (s1.charAt(x) != shifted.charAt(x)) {
                    return false;
                }
            }
            return true;
        }

        var shifteds1 = new ShiftedString(s1, cutoff);

        for (int x = 0; x < s1.length() - cutoff; x++) {
            var shifteds2 = new ShiftedString(s2, 1 + x);
            var found = true;
            for (int y = 0; y < s1.length(); y++) {
                if (shifteds1.charAt(y) != shifteds2.charAt(y)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }

        return false;
    }

}
