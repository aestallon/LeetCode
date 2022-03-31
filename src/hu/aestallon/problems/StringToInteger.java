package hu.aestallon.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>8. String to Integer (atoi)</b>
 * <p>
 * Implement the {@link #myAtoi(String)} function, which
 * converts a string to a 32-bit signed integer (similar
 * to C/C++'s {@code atoi} function).
 * </p><p>
 * The algorithm for {@link #myAtoi(String)} is as follows:
 * </p><ol>
 * <li>Read in and ignore any leading whitespace.
 * <li>Check if the next character (if not already at the
 * end of the string) is {@code '-'} or {@code '+'}. Read
 * this character in if it is either. This determines if
 * the final result is negative or positive respectively.
 * Assume the result is positive if neither is present.
 * <li>Read in next the characters until the next non-digit
 * character or the end of the input is reached. The rest of
 * the string is ignored.
 * <li>Convert these digits into an integer (i.e.
 * {@code "123" -> 123}, {@code "0032" -> 32)}. If no digits
 * were read, then the integer is {@code 0}. Change the sign
 * as necessary (from step 2).
 * <li>If the integer is out of the 32-bit signed integer
 * range {@code [-2<sup>31</sup>, 2<sup>31</sup> - 1]}, then
 * clamp the integer so that it remains in the range.
 * Specifically, integers less than {@code -2<sup>31</sup>}
 * should be clamped to {@code -2<sup>31</sup>},
 * and integers greater than {@code 2<sup>31</sup> - 1}
 * should be clamped to {@code 2<sup>31</sup> - 1}.
 * <li>Return the integer as the final result.
 * </ol><p>
 * <b>Note:</b>
 * </p><ul>
 * <li>Only the space character {@code ' '} is considered a
 * whitespace character.
 * <li><b>Do not ignore</b> any characters other than the
 * leading whitespace or the rest of the string after the
 * digits.
 * </ul><p>
 * <b>Constraints:</b>
 * </p><ul>
 * <li>{@code 0 <= s.length <= 200}
 * <li>{@code s} consists of English letters (lower-case
 * and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 * </ul><p>
 * Status: <b>ACCEPTED</b>
 * </p><ul>
 * <li>Speed: <i>4 ms -</i> beats 33.98 % of java submissions.
 * <li>Memory: <i>41.5 MB -</i> beats 99.91 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class StringToInteger {

    private static final String REGEX = "\\s*([+\\-]?)0*(\\d*)";
    private static final Pattern p = Pattern.compile(REGEX);

    /**
     * Parses a {@code String} for an {@code int}.
     *
     * @param s a {@code String}
     * @return the {@code int} value extracted from the String
     */
    public int myAtoi(String s) {
        final int MAX_LEN = 10;
        final int MAX_VAL = Integer.MAX_VALUE;

        Matcher m = p.matcher(s);
        if (!m.find()) {
            return 0;
        }

        boolean isNegative = m.group(1).equals("-");

        long lResult = 0;
        if (m.group(2).length() > 0) {

            char[] arr = m.group(2).toCharArray();

            if (arr.length > MAX_LEN) {
                lResult = (long) MAX_VAL + 1;
            } else {
                for (char ch : arr) {
                    lResult *= 10;
                    lResult += ch - '0';

                }
            }
        }

        if (lResult > MAX_VAL) {
            return isNegative ? Integer.MIN_VALUE : MAX_VAL;
        } else {
            return isNegative ? (int) lResult * -1 : (int) lResult;
        }
    }
}
