package hu.aestallon.problems;

/**
 * <b>53. Maximum Subarray</b>
 *
 * <p>Given an integer array {@code nums}, find the contiguous
 * subarray (containing at least one number) which has the largest
 * sum and return <i>its sum</i>.
 *
 * <p>A <b>subarray</b> is a <b>contiguous</b> part of an array.
 */
public class MaximumSubarray {

    /**
     * Provides solution to {@link MaximumSubarray}'s problem.
     *
     * <p>I didn't come up with this. Explanation can be found in the
     * relevant document found in the {@code resources} folder, or
     * on <a href="https://dl.acm.org/doi/pdf/10.1145/358234.381162">
     * this link</a>.
     *
     * <p>Labeling this problem "easy" is a certainly interesting
     * choice. In my opinion it's one of the outliers. Nevertheless,
     * the below method provides a top 1% solution for LeetCode.
     *
     * @param nums an {@code int[][]} array
     * @return the maximum sum found in any continuous sub-array of
     *         {@code nums}.
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

}
