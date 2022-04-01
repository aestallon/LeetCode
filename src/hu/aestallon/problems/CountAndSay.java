package hu.aestallon.problems;

/**
 * <b>38. Count and Say</b>
 * <p>
 * The <b>count-and-say</b> sequence is a sequence of
 * digit strings defined by the recursive formula:
 * </p><ul>
 * <li>{@code countAndSay(1) = "1"}
 * <li>{@code countAndSay(n)} is the way you would
 * "say" the digit string from {@code countAndSay(n-1)},
 * which is then converted into a different digit string.
 * </ul><p>
 * To determine how you "say" a digit string, split it
 * into the <b>minimal number</b> of groups so that each
 * group is a contiguous section all of the <b>same
 * character</b>. Then for each group, say the number of
 * characters, then say the character. To convert the
 * saying into a digit string, replace the counts with a
 * number and concatenate every saying.
 * </p><p>
 * Given a positive integer {@code n}, return <i>the
 * {@code n<sup>th</sup>} term of the <b>count-and-say</b>
 * sequence.</i>
 * </p><p>
 * Example 1:
 * </p><blockquote>
 * <code>
 * Input: n = 1;
 * Output: "1";
 * Explanation: This is the base case.
 * </code>
 * </blockquote><p>
 * Example 2:
 * </p><blockquote>
 * <code>
 * Input: n = 4;
 * Output: "1211";
 * Explanation:
 * <ul>
 * <li>countAndSay(1) = "1"
 * <li>countAndSay(2) = say "1" = one 1 = "11"
 * <li>countAndSay(3) = say "11" = two 1's = "21"
 * <li>countAndSay(4) = say "21" = one 2 + one 1 =
 * "12" + "11" = "1211"
 * </ul>
 * </code>
 * </blockquote><p>
 * <b>Constraints:</b>
 * </p><ul>
 * <li>{@code 1 <= n <= 30}
 * </ul><p>
 * Status: <b>ACCEPTED</b>
 * </p><ul>
 * <li>Speed: <i>3 ms -</i> beats 86.44 % of java submissions.
 * <li>Memory: <i>42.7 MB :</i> beats 42.93 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class CountAndSay {

    /**
     * Provides the count-and-say sequence of the parameter
     * based on the prescriptions of {@link CountAndSay}'s
     * description.
     *
     * @param n a non-zero positive {@code int}
     * @return the {@code String }corresponding count-and say
     *         sequence
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String prev = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            char currentCh = prev.charAt(0);

            for (int i = 0; i < prev.length(); i++) {
                if (prev.charAt(i) == currentCh) {
                    counter++;
                } else {
                    sb.append(counter).append(currentCh);
                    counter = 1;
                    currentCh = prev.charAt(i);
                }

                if (i == prev.length() - 1) {
                    sb.append(counter).append(currentCh);
                }
            }

            return sb.toString();
        }
    }

    // Driver function for testing purposes only.
    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        for (int i = 1; i < 10; i++) {
            System.out.println(i + ":\t" + cas.countAndSay(i));
        }
    }
}
