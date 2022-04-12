package hu.aestallon.problems;

/**
 * <b>27. Remove Element</b>
 *
 * <p>Given an integer array {@code nums} and an integer {@code val},
 * remove all occurrences of {@code val} in {@code nums} <b>in-place</b>.
 * The relative order of the elements may be changed.
 *
 * <p>Since it is impossible to change the length of the array in some
 * languages, you must instead have the result be placed in the <b>first
 * part</b> of the array {@code nums}. More formally, if there are
 * {@code k} elements after removing the duplicates, then the first
 * {@code k} elements of {@code nums} should hold the final result. It
 * does not matter what you leave beyond the first {@code k} elements.
 *
 * <p>Return {@code k} <i>after placing the final result in the first</i>
 * {@code k} <i>slots of</i> {@code nums}.
 *
 * <p>Do <b>not</b> allocate extra space for another array. You must do
 * this by <b>modifying the input array in-place</b> with O(1) extra memory.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>0 ms -</i> beats 100.0 % of java submissions.
 * <li>Memory: <i>41.1 MB -</i> beats 82.54 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
    }

}
