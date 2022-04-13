package hu.aestallon.problems;

/**
 * <b>35. Search Insert Position</b>
 *
 * <p>Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the
 * index where it would be if it were inserted in order.
 *
 * <p>You must write an algorithm with {@code O(log n)} runtime
 * complexity.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>0 ms -</i> beats 100.00 % of java submissions.
 * <li>Memory: <i>42.2 MB -</i> beats 81.59 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        // left and right pointers for the array
        int l = 0, r = nums.length - 1;
        // If target is smaller than anything in the array,
        // return 0 as its insert position.
        if (target < nums[l]) return 0;
        // If target is bigger than anything in the array,
        // return size of the array as its insert position.
        if (target > nums[r]) return r + 1;
        // Binary search is performed for the target.
        // If we find the target, we return its position.
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else return mid;
        }
        /* The binary search was constructed in a certain way:
         * the left pointer is only incremented by 1 if the
         * target was bigger than the evaluated entry.
         *
         * Hence, if the while loop terminates without ever
         * causing the method to return, then the target must be
         * bigger than nums[l] but cannot be found to the right of
         * it. As in the final iteration (l == r) l is incremented
         * by 1 (the `else if` branch), we can simply return l. */
         return l;
    }
}
