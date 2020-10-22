package io.github.mauricio;

import java.util.ArrayList;
import java.util.List;

public class ListNode<E> {
    private E element;
    private ListNode<E> next;

    public ListNode(E element, ListNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public static <E> ListNode<E> toLinkedList(E ... items) {
        ListNode<E> current = null;

        for (var x = items.length - 1; x >= 0; x--) {
            current = new ListNode<>(items[x], current);
        }

        return current;
    }

    public static <E> void deleteAt(ListNode<E> head, int index) {
        for (var x = 0; head.next != null; x++) {
            if (x == index) {
                var next = head.next;
                head.element = next.element;
                head.next = next.next;
                return;
            }
            head = head.next;
        }
    }

    public static <E> List<E> toList(ListNode<E> head) {
        var list = new ArrayList<E>();
        do {
            list.add(head.element);
            head = head.next;
        } while (head != null);

        return list;
    }

    public static <E> ListNode<E> getKthToLastElement(ListNode<E> element, int kth) {
         return kthToLast(element, kth).element;
    }

    public static <E extends Comparable<E>> ListNode<E> partition(ListNode<E> head, E element) {
        ListNode<E> left = null;
        ListNode<E> end = null;
        var first = head;

        ListNode<E> previous = null;

        while ( head != null ) {
            var result = element.compareTo(head.element);
            if (result > 0) {
                if (left == null) {
                    left = new ListNode<>(head.element, null);
                    end = left;
                } else {
                    left = new ListNode<>(head.element, left);
                }

                if (head.next != null) {
                    head.element = head.next.element;
                    head.next = head.next.next;
                } else {
                    if (previous != null) {
                        previous.next = null;
                    }
                    break;
                }
            } else {
                previous = head;
                head = head.next;
            }
        }

        if (end != null) {
            end.next = first;
            return left;
        }

        return first;
    }

    public static ListNode<Integer> sum(ListNode<Integer> left, ListNode<Integer> right) {
        return sumWithCarryover(left, right, 0);
    }

    public static ListNode<Integer> sumWithCarryover(ListNode<Integer> left, ListNode<Integer> right, Integer carry) {
        if (left == null && right == null && carry == 0) {
            return null;
        }

        var result = carry;
        ListNode<Integer> nextLeft = null;
        ListNode<Integer> nextRight = null;

        if (left != null) {
            result += left.element;
            nextLeft = left.next;
        }

        if (right != null) {
            result += right.element;
            nextRight = right.next;
        }

        var carryover = result % 10;
        if (result >= 10) {
            return new ListNode<>(carryover, sumWithCarryover(nextLeft, nextRight, 1));
        }

        return new ListNode<>(result, sumWithCarryover(nextLeft, nextRight, 0));
    }

    private static <E> KthResult<E> kthToLast(ListNode<E> element, int kth) {
        if (element.next == null) {
            ListNode<E> elem = null;
            if (kth == 0) {
                elem = element;
            }
            return new KthResult(elem, 0);
        }

        var result = kthToLast(element.next, kth);
        if (result.element != null) {
            return result;
        }

        var kthResult = result.currentIndex + 1;

        if (kthResult == kth) {
            return new KthResult(element, kthResult);
        }

        return new KthResult(null, kthResult);
    }

    public static <E> boolean palindrome(ListNode<E> head) {
        if (head.next == null) {
            return false;
        }

       return isPalindrome(head, head).previousResult;
    }

    private static <E> PalindromeResult<E> isPalindrome(ListNode<E> current, ListNode<E> head) {
        if (current.next == null) {
            return new PalindromeResult<>(head.next, current.element.equals(head.element));
        }

        var result = isPalindrome(current.next, head);
        if (!result.previousResult) {
            return result;
        }

        return new PalindromeResult<>(result.node.next, current.element.equals(result.node.element));
    }

    public static <E> ListNode<E> intersection(ListNode<E> left, ListNode<E> right) {
        var head = left;
        while (head != null) {
            var rightHead = right;
            while (rightHead != null) {
                if (head == rightHead) {
                    return head;
                }
                rightHead = rightHead.next;
            }
            head = head.next;
        }

        return null;
    }

}

class PalindromeResult<E> {
    ListNode<E> node;
    boolean previousResult;

    PalindromeResult(ListNode<E> element, boolean previousResult) {
        this.node = element;
        this.previousResult = previousResult;
    }

}

class KthResult<E> {

    KthResult(ListNode<E> element, int currentIndex) {
        this.element = element;
        this.currentIndex = currentIndex;
    }

    ListNode<E> element;
    int currentIndex;
}