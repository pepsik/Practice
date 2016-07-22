package task3;

/**
 * The {@code Task3} class represents a logic to calculate greatest common divisor (NOD) logic. E.g. input
 * <blockquote><pre>
 * new int {10, 5, 15}
 * </pre></blockquote>
 * <p>and result will be</p>
 * <blockquote><pre>
 * maxDivider = 5;
 * </pre></blockquote>
 */
public class Task3 {
    private int[] data; //input values

    /**
     * Initializes a newly created Task3 object with array of values and validate {@link Task3#checkValues()}
     *
     * @param data input values
     */
    public Task3(int... data) {
        this.data = data;
        checkValues();
    }

    /**
     * Finds greatest common divisor (GCD)
     *
     * @return max divider
     */
    public int getNOD() {
        int commonGCD = gcd2val(data[0], data[data.length - 1]); // gcd between first and last values in data

        for (int i = 1; i < data.length; i++) {
            int gcd = gcd2val(data[i - 1], data[i]);
            if (gcd < commonGCD) {
                commonGCD = gcd;
            }
        }
        return commonGCD;
    }

    private int gcd2val(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd2val(b, a % b);
    }

    /**
     * Validate data values
     * @throws IllegalArgumentException in case data[i] < 1
     */
    private void checkValues() {
        for (int value : data)
            if (value < 1) {
                throw new IllegalArgumentException("Value must be greater than 0");
            }
    }
}
