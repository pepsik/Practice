package task4;

import java.util.ArrayList;
import java.util.List;

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
    private static List<Integer> fibList = new ArrayList<>(); //cache for fib numbers

    /**
     * Initializes a newly created Task4 object with first three fibonacci numbers
     */
    public Task4() {
        fibList.add(0);
        fibList.add(1);
        fibList.add(1);
    }
    //todo recurs

    /**
     * Calculates fib number using N index
     *
     * @param N input fib N
     * @return fib number
     */
    public int fib(int N) {
        checkValue(N);
        if (fibList.size() - 1 != N) { // if no value in cache //tOdo fix N >
            calculateFib(N);
        }
        return fibList.get(N);
    }

    /**
     * Calculate and add new Fib numbers to list
     *
     * @param N input fib N
     */
    private void calculateFib(int N) {
        for (int i = fibList.size() - 1; i <= N; i++) { // starts with last known fib number (size -1)
            int result = checksFib(fibList.get(i - 1), fibList.get(i)); // checks if integer overflow
            fibList.add(result);
        }
    }

    /**
     * Sum 2 fib numbers
     *
     * @param f last fib number N
     * @param s N-1 fib number
     * @return sum last fib numbers N + (N -1)
     */
    private int checksFib(int f, int s) {
        if (Integer.MAX_VALUE - f < s) {
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
