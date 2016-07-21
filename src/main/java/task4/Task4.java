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
//    public int fib(int N) {
//        checkValue(N);
//        return calculate(N);
//    }
//
//    private int calculate(int N) {
//        if (N <= 1) return N;
//        else return fib(N - 1) + fib(N - 2);
//    }

    private List<Integer> list = new ArrayList<>();

    /**
     * Initializes a newly created Task4 object with first three fibonacci numbers
     */
    public Task4() {
        list.add(0);
        list.add(1);
        list.add(1);
    }

    /**
     * Checks values if they are not bigger than 1 then {@link IllegalArgumentException} will thrown
     * @param N input fib N
     */
    private void checkValue(int N) {
        if (N < 0)
            throw new IllegalArgumentException("N Should more than 0");
    }

    /**
     * Calculates fib number using N index
     * @param N input fib N
     * @return fib number
     */
    public int fib(int N) {
        checkValue(N);
        for (int i = 2; i < N + 1; i++) {
            list.add(Math.addExact(list.get(i - 1), list.get(i)));//todo refactor
        }
        return list.get(N);
    }

    public static void main(String[] args) {
        System.out.println(new Task4().fib(45));
    }
}
