package hu.aestallon.problems;

/**
 * <b>704. Binary Search</b>
 *
 * <p>Given an array of integers {@code nums} which is sorted in
 * ascending order, and an integer {@code target}, write a function
 * to search {@code target} in {@code nums}. If {@code target}
 * exists, then return its index. Otherwise, return {@code -1}.
 *
 * <p>You must write an algorithm with {@code O(log n)} runtime
 * complexity.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>0 ms -</i> beats 100.00 % of java submissions.
 * <li>Memory: <i>43.2 MB -</i> beats 81.15 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] arr, int l, int r, int target) {
        if (r < l) return -1;
        else {
            int pivot = (l + r) / 2;
            if (target < arr[pivot]) {
                return binarySearch(arr, l, pivot - 1, target);
            } else if (target > arr[pivot]) {
                return binarySearch(arr, pivot + 1, r, target);
            } else return pivot;
        }
    }
}

