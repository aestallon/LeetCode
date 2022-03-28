package hu.aestallon.problems;

import java.util.HashMap;

/**
 * <b>1. Two Sum</b>
 * <p>
 * Given an array of integers {@code nums} and an integer
 * {@code target}, <i>return indices of the two numbers
 * such that they add up to {@code target}.</i>
 * </p><p>
 * You may assume that each input would have <b><i>exactly</i>
 * one solution</b>, and you may not use the <i>same</i>
 * element twice.
 * </p><p>
 * You can return the answer in any order.
 * </p><p>
 * <b>Constraints:</b>
 * </p><ul>
 * <li>{@code 2 <= nums.length <= 10<sup>4</sup>}
 * <li>{@code -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>}
 * <li>{@code -10<sup>9</sup> <= target <= 10<sup>9</sup>}
 * <li><b>Only one valid answer exists.</b>
 * </ul><p>
 * Status: <b>ACCEPTED</b>
 * </p><ul>
 * <li>Speed: <i>4 ms -</i> beats 70.34 % of java submissions.
 * <li>Memory: <i>45.6 MB :</i> beats 40.81 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1);

        int i = 0;
        while (i < nums.length && result[1] == -1) {
            if (nums[i] * 2 == target) {
                if (result[0] == -1) {
                    result[0] = i;
                } else {
                    result[1] = i;
                }
            } else {
                map.put(nums[i], i);
                int needed = target - nums[i];

                if (map.containsKey(needed)) {
                    result[0] = map.get(needed);
                    result[1] = map.get(nums[i]);
                }
            }
            i++;
        }
        return result;
    }
}
