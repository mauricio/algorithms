package io.github.mauricio.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortTest {

    @Test
    public void testSort() {
        assertSorted(newRandomList(100));
        assertSorted(newRandomList(500));
        assertSorted(newRandomList(25));
    }

    public static void assertSorted(List<Integer> items) {
        var expected = clone(items);
        Collections.sort(expected);

        var sort = clone(items);
        Sort.sort(sort);

        assertEquals(expected, sort);

        var quicksort = clone(items);
        Sort.quicksort(quicksort);

        assertEquals(expected, quicksort);

    }

    public static List<Integer> newRandomList(int count) {
        List<Integer> items = new ArrayList<>(count);
        var r = new Random(1000);

        for (int x = 0; x < count; x++) {
            items.add(r.nextInt(count + 10));
        }

        return items;
    }

    private static <E> List<E> clone(List<E> items) {
        var cloned =  new ArrayList<E>();
        cloned.addAll(items);
        return cloned;
    }

}
