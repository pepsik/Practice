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
    private static List<Integer> fList = new ArrayList<>(); //cache for fib numbers

    static {
        fList.add(0);
    }

    /**
     * Calculates fib number using N index
     *
     * @param N input fib N
     * @return fib number
     */

    public int fib(int N) {
        checkValue(N);
        return calculate(N);
    }

    /**
     * Calculate and add new Fib numbers to list
     *
     * @param N input fib N
     */
    private int calculate(int N) {
        if (N <= 1) {
            return N;
        }

        if (N < fList.size()) {
            return fList.get(N);
        }

        int result = sum2Fib(fib(N - 2), fib(N - 1));
        fList.add(result);
        return result;
    }

    /**
     * Sum last known N and N-1 fib numbers
     *
     * @param f last fib number N
     * @param s N-1 fib number
     * @return sum last fib numbers N + (N -1)
     */
    private int sum2Fib(int f, int s) {
        if (f > MAX_VALUE - s) {
            throw new ArithmeticException();
        }
        return f + s;
    }

    /**
     * Validate value N
     *
     * @param N input fib N
     * @throws IllegalArgumentException in case N < 0
     */
    private void checkValue(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("N Should more than 0");
        }

    }
}
