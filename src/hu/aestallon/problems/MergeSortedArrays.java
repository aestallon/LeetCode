package hu.aestallon.problems;

/**
 * <b>88. Merge Sorted Array</b>
 *
 * <p>You are given two integer arrays {@code nums1} and {@code nums2},
 * sorted in <b>non-decreasing order</b>, and two integers {@code m}
 * and {@code n}, representing the number of elements in {@code nums1}
 * and {@code nums2} respectively.
 *
 * <p>Merge {@code nums1} and {@code nums2} into a single array sorted
 * in <b>non-decreasing order</b>.
 *
 * <p>The final sorted array should not be returned by the function,
 * but instead be <i>stored inside the array</i> {@code nums1}. To
 * accommodate this, {@code nums1} has a length of {@code m + n}, where
 * the first {@code m} elements denote the elements that should be
 * merged, and the last {@code n} elements are set to 0 and should be
 * ignored. {@code nums2} has a length of {@code n}.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>0 ms -</i> beats 100.00 % of java submissions.
 * <li>Memory: <i>42.5 MB -</i> beats 76.98 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // If there are 0 elements to merge from nums1, we
        // can just copy nums2 to nums1, and call it a day.
        if (m < 1) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        // If nums1 is the result itself, we can do nothing.
        if (m == nums1.length) {
            return;
        }

        int p1 = m - 1, p2 = n - 1; // Pointers to the two arrays.
        for (int i = nums1.length - 1; i >= 0; i--) {
            // If we have no more elements to merge from nums1,
            // we can copy the remaining items from nums2, and
            // break.
            if (p1 < 0) {
                System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
                break;
            }
            // If we have no more elements to merge from nums2,
            // the resulting nums1 is already merged and sorted.
            if (p2 < 0) {
                break;
            }

            if (nums2[p2] >= nums1[p1]) {
                nums1[i] = nums2[p2];
                p2--;
            } else {
                nums1[i] = nums1[p1];
                p1--;
            }
        }
    }

}
