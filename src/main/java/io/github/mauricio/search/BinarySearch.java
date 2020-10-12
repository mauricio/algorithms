package io.github.mauricio.search;

import java.util.List;

public class BinarySearch {

    public static  <E extends Comparable<E>> int indexOf(List<E> items, E item) {
        if (items.isEmpty()) {
            return -1;
        }

        return binarySearch(items, item, 0, items.size() - 1);
    }

    public static  <E extends Comparable<E>> int binarySearch(List<E> items, E item) {
        if (items.isEmpty()) {
            return -1;
        }

        var start = 0;
        var end = items.size();

        while ((end - start) != 0) {
            var pivotIndex = (start + end)/2;
            var pivot = items.get(pivotIndex);

            var compare = item.compareTo(pivot);
            if (compare == 0) {
                return pivotIndex;
            }

            if (compare < 0) {
                end = pivotIndex - 1;
                continue;
            }

            start = pivotIndex + 1;
        }

        return -1;
    }

    private static <E extends Comparable<E>> int binarySearch(List<E> items, E item, int start, int end) {
        var length = (end - start);
        if (length == 0) {
            return -1;
        }

        var pivotIndex = (length/2) + start;
        var pivot = items.get(pivotIndex);
        var compareResult = item.compareTo(pivot);
        if (compareResult == 0) {
            return pivotIndex;
        }

        if (compareResult < 0) {
            return binarySearch(items, item, start, pivotIndex - 1);
        }

        return binarySearch(items, item, pivotIndex + 1, end);
    }

}
