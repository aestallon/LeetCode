package hu.aestallon.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>217. Contains Duplicate</b>
 *
 * <p>Given an integer array {@code nums}, return {@code true} if
 * any value appears <b>at least twice</b> in the array, and return
 * {@code false} if every element is distinct.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>6 ms -</i> beats 96.06 % of java submissions.
 * <li>Memory: <i>55 MB -</i> beats 86.74 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class ContainsDuplicate {

    /**
     * Checks if an {@code int[]} array contains duplicate entries.
     *
     * @param nums an {@code int[]} array
     * @return true if at least two entries are identical, false
     *         otherwise.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else set.add(num);
        }
        return false;
    }

}
