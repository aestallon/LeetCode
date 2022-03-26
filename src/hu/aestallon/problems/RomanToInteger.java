package hu.aestallon.problems;

public class RomanToInteger {

    private static final char[] DIGITS =
            {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    /**
     * Converts a Roman numeral into an integer.
     *
     * @param s a {@code String} representing a valid
     *          Roman numeral
     * @return an {@code int} with the parameter's value
     */
    public int romanToInt(String s) {
        char[] letters = s.toCharArray();
        if (letters.length < 1 || letters.length > 15) {
            throw new IllegalArgumentException("Provided string is not of the accepted length (1-15)!");
        }
        if (!hasValidLetters(s.toCharArray())) {
            throw new IllegalArgumentException("Provided string contains invalid letters!");
        }

        int[] values = convertToValues(letters);
        if (!hasValidFormat(values)) {
            throw new IllegalArgumentException("Provided Roman numeral has invalid format!");
        }
        accountForSubtraction(values);
        int result = 0;
        for (int i : values) {
            result += i;
        }

        return result;
    }

    /**
     * Checks an array if it contains only characters
     * used in writing Roman numerals.
     *
     * @param chArray a {@code char[]}
     * @return true if every element is a valid character,
     *         else false.
     */
    private boolean hasValidLetters(char[] chArray) {
        boolean result = true;

        // Check if we have any illegal characters
        for (char ch : chArray) {
            boolean validLetter = false;

            for (char digit : DIGITS) {
                if (ch == digit) {
                    validLetter = true;
                    break;
                }
            }

            if (!validLetter) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Converts an {@code char[]} representing a Roman
     * numerals into an {@code int[]}.
     *
     * @param chArray a {@code char[]} representing a
     *                Roman numeral
     * @return an {@code int[]}, every element of which
     *         is the raw Roman value of the letter of
     *         the original array.
     */
    private int[] convertToValues(char[] chArray) {
        int[] values = new int[chArray.length];
        for (int i = 0; i < chArray.length; i++) {
            switch (chArray[i]) {
                case 'I' -> values[i] = 1;
                case 'V' -> values[i] = 5;
                case 'X' -> values[i] = 10;
                case 'L' -> values[i] = 50;
                case 'C' -> values[i] = 100;
                case 'D' -> values[i] = 500;
                case 'M' -> values[i] = 1000;
            }
        }
        return values;
    }

    /**
     * Checks if an array of integers is in a correct
     * sequence used in Roman numerals
     *
     * @param values an {@code int[]} containing numbers
     *               representing the value of a Roman
     *               digit.
     * @return true if the sequence adheres to the rules
     *         writing Roman numerals, else false.
     */
    private boolean hasValidFormat(int[] values) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            boolean validDigit = (values[i] <= values[i - 1]) ||
                    ((values[i] / values[i - 1]) == 5 ||
                            (values[i] / values[i - 1]) == 10);
            if (!validDigit) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Flips the necessary values to negative in an
     * {@code int[]} representing the raw values of a
     * Roman numeral.
     * <p>
     * Raw values only contain positive numbers, but
     * in certain positions the values are used for
     * subtraction instead of addition. This method
     * flips those values into their negative counterpart.
     * </p>
     *
     * @param values an {@code int[]} representing the
     *               raw values of a Roman numeral.
     */
    private void accountForSubtraction(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] < values[i + 1]) values[i] *= -1;
        }
    }
}