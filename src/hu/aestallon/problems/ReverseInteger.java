package hu.aestallon.problems;

import java.util.ArrayList;

/**
 * <b>7. Reverse Integer</b>
 * <p>
 * Given a signed 32-bit integer {@code x}, return {@code x}
 * with its digits reversed. If reversing x causes the value
 * to go outside the signed 32-bit integer range
 * {@code [-2<sup>31</sup>, 2<sup>31</sup> - 1]}, then return
 * {@code 0}.
 * </p><p>
 * Assume the environment does not allow you to store 64-bit
 * integers (signed or unsigned).
 * </p><p>
 * Example 1:
 * </p><blockquote>
 * <code>
 * Input: x = 123; Output: 321
 * </code>
 * </blockquote><p>
 * Example 2:
 * </p><blockquote>
 * <code>
 * Input: x = -123; Output: -321
 * </code>
 * </blockquote><p>
 * Example 3:
 * </p><blockquote>
 * <code>
 * Input: x = 120; Output: 21
 * </code>
 * </blockquote><p>
 * <b>Constraints:</b>
 * </p><ul>
 * <li>{@code -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1}
 * </ul><p>
 * Status: <b>ACCEPTED</b>
 * </p><ul>
 * <li>Speed: <i>3 ms -</i> beats 26.37 % of java submissions.
 * <li>Memory: <i>41.4 MB -</i> beats 56.00 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class ReverseInteger {

    /**
     * Reverses an integer.
     *
     * @param x an {@code int}
     * @return the digit-by-digit reverse of {@code x}. If the
     *         reversal yields a number overflowing the capacity
     *         of a signed 32-bit integer, {@code 0} is returned.
     */
    public int reverse(int x) {
        boolean isNegative = x < 0;

        ArrayList<Integer> digits = new ArrayList<>();
        while (x != 0) {
            digits.add(x % 10);
            x /= 10;
        }

        int res = 0, prev;
        for (Integer i : digits) {
            prev = res;
            res *= 10;
            if (res / 10 != prev) {
                res = 0;
                break;
            } else {
                res += i;
            }
        }

        if ((isNegative && res > 0) || (!isNegative && res < 0)) {
            return 0;
        } else {
            return res;
        }
    }
}
