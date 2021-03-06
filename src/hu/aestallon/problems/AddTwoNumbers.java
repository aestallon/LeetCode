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
 * </ul><p>
 * Status: <b>ACCEPTED</b>
 * </p><ul>
 * <li>Speed: <i>5 ms -</i> beats 12.41 % of java submissions.
 * <li>Memory: <i>48 MB :</i> beats 34.77 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class AddTwoNumbers {

    /**
     * Adds two numbers stored in {@link ListNode} formats together.
     *
     * @param l1 a number stored in a {@code ListNode}
     * @param l2 a number stored in a {@code ListNode}
     * @return the sum of the parameters as an instance of {@code ListNode}.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        ListNode digit1 = l1;
        ListNode digit2 = l2;
        ListNode digitResult = result;

        while (digit1 != null || digit2 != null) {

            if (digit1 != null) {
                // store digit's value in result
                digitResult.val += digit1.val;

                // update the digit's pointer
                if (digit1.next != null) {
                    digit1 = digit1.next;
                } else {
                    digit1 = null;
                }
            }

            if (digit2 != null) {
                // store digit's value in result
                digitResult.val += digit2.val;

                // update the digit's pointer
                if (digit2.next != null) {
                    digit2 = digit2.next;
                } else {
                    digit2 = null;
                }
            }

            //handle a 'digit' higher than 10
            if (digitResult.val >= 10) {
                digitResult.val -= 10;
                digitResult.next = new ListNode(1);
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
