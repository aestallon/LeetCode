package hu.aestallon.utils;

/**
 * Describes a linked list for storing numbers
 * in base10 using "big endian" notation.
 * <p>
 * Provided for <b>2. Add Two Numbers</b>.
 * </p>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
