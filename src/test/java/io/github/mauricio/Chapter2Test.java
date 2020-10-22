package io.github.mauricio;

import static io.github.mauricio.Chapter2.*;
import static io.github.mauricio.ListNode.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Chapter2Test {

    @Test
    public void testUniq() {
        var items = new LinkedList<Integer>();
        items.addAll(Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3));
        uniq(items);
        assertEquals(Arrays.asList(1, 2, 3), items);
    }

    @Test
    public void testKth() {
        var list = toLinkedList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(getKthToLastElement(list, 0).getElement(), Integer.valueOf(9));
        assertEquals(getKthToLastElement(list, 2).getElement(), Integer.valueOf(7));
        assertEquals(getKthToLastElement(list, 4).getElement(), Integer.valueOf(5));
        assertNull(getKthToLastElement(list, 20));
    }

    @Test
    public void testDeleteAt() {
        var list = toLinkedList(0, 1, 2);
        deleteAt(list, 1);
        assertEquals(Arrays.asList(0, 2), toList(list));
    }

    @Test
    public void testPartition() {
        var list = toLinkedList(3, 5, 8, 5, 10, 2, 1);
        var result = partition(list, 5);
        assertEquals(Arrays.asList(1, 2, 3, 5, 8, 5, 10), toList(result));
    }

    @Test
    public void testPartitionFirst() {
        var list = toLinkedList(5, 3, 8, 5, 10, 2, 1);
        var result = partition(list, 5);
        assertEquals(Arrays.asList(1, 2, 3, 5, 8, 5, 10), toList(result));
    }

    @Test
    public void testPartitionLast() {
        var list = toLinkedList(3, 8, 10, 2, 1, 5);
        var result = partition(list, 5);
        assertEquals(Arrays.asList(1, 2, 3, 8, 10, 5), toList(result));
    }

    @Test
    public void testPartitionNotFound() {
        var list = toLinkedList(3, 8, 10, 2, 1);
        var result = partition(list, 5);
        assertEquals(Arrays.asList(1, 2, 3, 8, 10), toList(result));
    }

    @Test
    public void testSum() {
        var result = sum(toLinkedList(7, 1, 6), toLinkedList(5, 9, 2));
        assertEquals(Arrays.asList(2, 1, 9), toList(result));

        var result3 = sum(toLinkedList(7, 1, 6), toLinkedList(5, 9, 3));
        assertEquals(Arrays.asList(2, 1, 0, 1), toList(result3));

        var otherResult = sum(toLinkedList(0, 1), toLinkedList(1, 0, 1));
        assertEquals(Arrays.asList(1, 1, 1), toList(otherResult));
    }

    @Test
    public void testPalindrome() {
        assertTrue(palindrome(toLinkedList(0, 1, 2, 1, 0)));
        assertFalse(palindrome(toLinkedList(0, 1, 0, 1)));
    }

    @Test
    public void testIntersection() {
        var intersection = toLinkedList(7, 8, 9);
        var three = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, intersection)));
        var two = new ListNode<>(10, new ListNode<>(11, intersection));

        assertEquals(intersection, intersection(three, two));
        assertNull(intersection(three, toLinkedList(1, 2, 3, 4, 5, 6)));
    }

}
