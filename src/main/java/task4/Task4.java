package task4;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

/**
 * The {@code Task4} class represents a logic to calculate Fibonacci number. E.g.
 * <blockquote><pre>
 * N = 6
 * </pre></blockquote>
 * <p>and result will be</p>
 * <blockquote><pre>
 * fibNumber = 8
 * </pre></blockquote>
 */
public class Task4 {
    /**
     * Minimum possible fib number
     */
    private static final int MIN_N = 0;

    /**
     * Maximum possible fib number
     */
    private static final int MAX_N = 46;

    /**
     * Cache for fib values
     * Starts N = 0,1 with fib(1) = 0, fib(1) = 1
     */
    private static List<Integer> fList = new ArrayList<>();

    /**
     * Calculates fib(N)
     *
     * @param N input fib index N
     * @return fib(N)
     */
    public int fib(int N) {
        if (N < MIN_N) {
            throw new IllegalArgumentException("N Should more than " + MIN_N + " but WAS: " + N);
        }
        if (N > MAX_N) {
            throw new IllegalArgumentException("N Should less than " + MAX_N + " but WAS: " + N);
        }
        return calculate(N);
    }

    /**
     * Calculate and add new fib numbers to list
     * Starts fib(0) = 0, fiv(1) = 1
     *
     * @param N input fib index N
     */
    private int calculate(int N) {
        if (N <= 1) {
            return N;
        }

        if (N - 1 < fList.size()) {
            return fList.get(N - 1);
        }

        int result = fib(N - 2) + fib(N - 1);
        fList.add(result);
        return result;
    }
}
