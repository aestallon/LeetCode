package hu.aestallon.problems;

import hu.aestallon.utils.ListNode;

/**
 * <b>2. Add Two Numbers</b>
 * <p>
 * You are given two <b>non-empty</b> linked lists representing
 * two non-negative integers. The digits are stored in
 * <b>reverse order</b>, and each of their nodes contains a single
 * digit. Add the two numbers and return the sum as a linked list.
 * </p><p>
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 * </p><p>
 * Example 1:
 * </p><blockquote>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * </blockquote><p>
 * Example 2:
 * </p><blockquote>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * </blockquote><p>
 * Example 3:
 * </p><blockquote>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * </blockquote><p>
 * <b>Constraints:</b>
 * </p><ul>
 * <li>The number of nodes in each linked list is in the range
 * [1, 100].
 * <li>0 <= Node.val <= 9
 * <li>It is guaranteed that the list represents a number that
 * does not have leading zeros
 * </ul>
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digitSum = 0;
        ListNode result = new ListNode();
        ListNode digit1 = l1;
        ListNode digit2 = l2;
        ListNode digitResult = result;

        while (digit1 != null || digit2 != null) {

            // add two digits to the result
            if (digit1 != null) {
                digitResult.val += digit1.val;
            }
            if (digit2 != null) {
            digitResult.val += digit2.val;
            }

            //handle a 'digit' higher than 10
            if (digitResult.val >= 10) {
                digitResult.val -= 10;
                digitResult.next = new ListNode(1);
            }

            // update both digit pointers
            try {
                digit1 = digit1.next;
            } catch (NullPointerException e) {
                digit1 = null;
            }

            try {
                digit2 = digit2.next;
            } catch (NullPointerException e) {
                digit2 = null;
            }

            // update the result digit pointer
            if (digitResult.next != null) {
                digitResult = digitResult.next;
            } else {
                if (digit1 != null || digit2 != null) {
                    digitResult.next = new ListNode();
                    digitResult = digitResult.next;
                }
            }
        }

        return result;
    }
}
