package task4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task4 {
//    public int fib(int N) {
//        validation(N);
//        return calculate(N);
//    }
//
//    private int calculate(int N) {
//        if (N <= 1) return N;
//        else return fib(N - 1) + fib(N - 2);
//    }

    public List<Integer> list = new ArrayList<>();

    private void setup() {
        list.clear();
        list.add(0);
        list.add(1);
        list.add(1);
    }

    private void validation(int N) {
        if (N < 0)
            throw new IllegalArgumentException("N Should more than 0 inclusive");
    }

    public int fib(int N) {
        setup();
        validation(N);
        for (int i = 2; i < N + 1; i++) {
            list.add(Math.addExact(list.get(i - 1), list.get(i)));
        }
        return list.get(N);
    }

    public static void main(String[] args) {
        System.out.println(new Task4().fib(45));
    }
}
