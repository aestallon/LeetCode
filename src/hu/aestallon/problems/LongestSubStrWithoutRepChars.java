package hu.aestallon.problems;

import java.util.ArrayList;

/**
 * <b>3. Longest Substring Without Repeating Characters</b>
 * <p>
 * Given a string {@code s}, find the length of
 * the <b>longest substring</b> without repeating characters.
 * </p><p>
 * <b>Constraints:</b>
 * </p><ul>
 * <li>{@code 0 <= s.length <= 5 * 10<sup>4</sup>}
 * <li>{@code s} consists of English letters, digits, symbols
 * and spaces.
 * </ul><p>
 * Status: <b>ACCEPTED</b>
 * </p><ul>
 * <li>Speed: <i>4 ms -</i> beats 95.76 % of java submissions.
 * <li>Memory: <i>42.2 MB -</i> beats 92.78 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class LongestSubStrWithoutRepChars {

    /**
     * Finds the length of the longest substring of the parameter.
     *
     * @param s a {@code String}
     * @return the {@code int} length of the longest substring.
     */
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int result = 0;

        int lP = 0, rP = 0, current = 0;
        while (rP < arr.length) {
            if (contains(arr[rP], arr, lP, rP)) {
                current--;
                lP++;
            } else {
                current++;
                rP++;
                result = Math.max(current, result);
            }
        }
        return result;
    }

    /**
     * Checks if a certain slice of a {@code char[]} character array
     * contains the given character or not.
     *
     * @param ch    a {@code char} to be found
     * @param chars a {@code char[]} array
     * @param from  {@code int} starting index in the array (inclusive)
     * @param to    {@code int} final index in the array (exclusive)
     * @return true, if the character is an entry of the provided slice,
     *         else false.
     */
    private boolean contains(char ch, char[] chars, int from, int to) {
        for (int i = from; i < to; i++) {
            if (chars[i] == ch) {
                return true;
            } else if (chars[i] == '\0') {
                break;
            }
        }
        return false;
    }

    /**
     * Finds the length of the longest substring of the parameter.
     * <i><p>
     * Using this method is very slow (LeetCode tests finish in
     * ~38 ms instead of 8 ms), because using reference types
     * (like {@link Character}) and {@link ArrayList} is slow.
     * </p><p>
     * I decided still to leave this solution in here, because
     * it's maybe easier to read than the faster one.
     * </p></i>
     *
     * @param s a {@code String}
     * @return the {@code int} length of the longest substring.
     */
    public int lengthOfLongestSubstring_WithArrayList(String s) {
        char[] arr = s.toCharArray();
        int result = 0;

        int lP = 0, rP = 0, current = 0;
        ArrayList<Character> list = new ArrayList<>(arr.length);
        while (rP < arr.length) {
            if (list.contains(arr[rP])) {
                list.remove(Character.valueOf(arr[lP]));
                current--;
                lP++;
            } else {
                list.add(arr[rP]);
                current++;
                rP++;
                result = Math.max(current, result);
            }
        }
        return result;
    }
}
