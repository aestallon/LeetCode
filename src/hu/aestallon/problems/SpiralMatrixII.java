package hu.aestallon.problems;

import java.util.Arrays;

/**
 * <b>59. Spiral Matrix II</b>
 *
 * <p>Given a positive integer {@code n}, generate an
 * {@code n x n matrix} filled with elements from {@code 1} to
 * {@code n<sup>2</sup>} in spiral order.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>0 ms -</i> beats 100.0 % of java submissions.
 * <li>Memory: <i>40.5 MB -</i> beats 82.25 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int r = 0, c = 0; // pointers to current cell.
        int left = -1, right = n, up = 0, down = n; // limits where we can put values
        int val = 1;

        while (val <= (n * n)) {
            while (c < right) {
                result[r][c++] = val++;
            }
            c--;
            right--;
            r++;

            while (r < down) {
                result[r++][c] = val++;
            }
            r--;
            down--;
            c--;

            while (c > left) {
                result[r][c--] = val++;
            }
            c++;
            left++;
            r--;

            while (r > up) {
                result[r--][c] = val++;
            }
            r++;
            up++;
            c++;
        }

        return result;
    }

    // for testing
    public static void main(String[] args) {
        printArray(new SpiralMatrixII().generateMatrix(3));
    }

    /** Prints a {@code int[][]} array to standard output. */
    private static void printArray(int[][] arr) {
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
    }
}
