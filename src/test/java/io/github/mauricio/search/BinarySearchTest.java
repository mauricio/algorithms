package io.github.mauricio.search;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearchTest {

    @Test
    public void testIndexOf() {
        var items = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(7, BinarySearch.indexOf(items, 9));
        assertEquals(7, BinarySearch.binarySearch(items, 9));

        assertEquals(-1, BinarySearch.binarySearch(Collections.emptyList(), 10));
        assertEquals(-1, BinarySearch.indexOf(Collections.emptyList(), 10));

        assertEquals(-1, BinarySearch.indexOf(items, 11));
        assertEquals(-1, BinarySearch.binarySearch(items, 11));

    }

}
