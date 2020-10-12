package io.github.mauricio.sorting;

import java.util.List;

public class Sort {

    public static  <E extends Comparable<E>> void sort(List<E> items) {
        if (items.isEmpty() || items.size() == 1) {
            return;
        }

        for (int x = 0; x < items.size(); x++) {
            var smallest = items.get(x);
            var smallestIndex = x;
            for (int y = x + 1; y < items.size(); y++) {
                var next = items.get(y);
                if (smallest.compareTo(next) > 0) {
                    smallestIndex = y;
                    smallest = next;
                }
            }

            if (smallestIndex != x) {
                var next = items.get(smallestIndex);
                items.set(smallestIndex, items.get(x));
                items.set(x, smallest);
            }
        }
    }

    public static  <E extends Comparable<E>> void quicksort(List<E> items) {
        if (items.size() <= 1) {
            return;
        }
        var pivotIndex = partition(items);
        quicksort(items.subList(0, pivotIndex));
        quicksort(items.subList(pivotIndex + 1, items.size()));
    }

    private static <E extends Comparable<E>> int partition(List<E> items) {
        var pivot = items.get(0);
        var pivotIndex = 0;

        for (int x = 1; x < items.size(); x++) {
            var element = items.get(x);
            if (pivot.compareTo(element) > 0) {
                items.remove(x);
                items.add(pivotIndex, element);
                pivotIndex++;
            }
        }

        return pivotIndex;
    }

}
