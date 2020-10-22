package io.github.mauricio;

import java.util.List;

public class Chapter2 {

    public static <E> void  uniq(List<E> items) {
        for (var x = 0; x < items.size(); x++) {
            var current = items.get(x);
            items.subList(x + 1, items.size()).removeIf(current::equals);
        }
    }

}
