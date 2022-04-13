package hu.aestallon.problems;

import hu.aestallon.utils.VersionControl;

/**
 * <b>278. First Bad Version</b>
 *
 * <p>ou are a product manager and currently leading a team to develop
 * a new product. Unfortunately, the latest version of your product
 * fails the quality check. Since each version is developed based on
 * the previous version, all the versions after a bad version are also bad.
 *
 * <p>Suppose you have {@code n} versions {@code [1, 2, ..., n]} and you
 * want to find out the first bad one, which causes all the following ones
 * to be bad.
 *
 * <p>You are given an API {@code bool isBadVersion(version)} which
 * returns whether {@code version} is bad. Implement a function to find
 * the first bad version. You should minimize the number of calls to the API.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>13 ms -</i> beats 86.54 % of java submissions.
 * <li>Memory: <i>39 MB -</i> beats 86.46 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class FirstBadVersion extends VersionControl {

    /**
     * Finds the first bad version based on {@link VersionControl} API.
     *
     * @param n {@code int} version number
     * @return the {@code int} version number of the oldest bad version.
     */
    /*
     * Binary search is performed to find the earliest bad version, as
     * such, the method's time complexity is O(log N).
     */
    public int firstBadVersion(int n) {
        int candidate = 0, bad = n;
        while (candidate < bad) {
            int mid = candidate + (bad - candidate) / 2;
            if (!isBadVersion(mid)) {
                candidate = mid + 1;
            } else {
                bad = mid;
            }
        }
        return candidate;
    }
}
