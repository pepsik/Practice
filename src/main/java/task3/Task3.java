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
    private int[] data;

    /**
     * Initializes a newly created Task3 object with int array of values and checks it {@link Task3#checkValues()}
     * @param data input values
     */
    public Task3(int[] data) {
        this.data = data;
        checkValues();
    }

    /**
     * Finds greatest common divisor (GCD)
     * @return max divider
     */
    public int getNOD() {
        int min = findMinOfData();
        int gcd = -1;

        // finding max divider
        for (int i = min; i > 0; i--) {//todo simplify
            gcd = i;//supposed it was found

            //check if gcd is expected divider of all data values
            for (int value : data) {

                //if not divisible - skip (assigned -1)
                if (value % i != 0) {
                    gcd = -1;
                    break;
                }
            }
            //break if gcd found
            if (gcd != -1)//todo all with brackets
                break;
        }
        return gcd;
    }

    /**
     * Checks values if they are not bigger than 1 - {@link IllegalArgumentException} will thrown
     */
    private void checkValues() {
        for (int value : data)
            if (value < 1) {
                throw new IllegalArgumentException();
            }
    }

    /**
     * Finds minimum values of input array values
     * @return min value
     */
    private int findMinOfData() {
        int min = Integer.MAX_VALUE;
        for (int value : data) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }
}
