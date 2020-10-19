package io.github.mauricio;

import java.util.Arrays;
import java.util.HashMap;

public class Chapter1 {

    public static boolean isUniqueHash(String s) {
        var chars = new HashMap<Character,Boolean>();

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

}
