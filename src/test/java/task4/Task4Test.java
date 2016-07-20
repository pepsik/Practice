package task4;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task4Test {
    private static final String MESSAGE = "Expected exception !NOT THROWN!";

    @Test
    public void validNValues() {
        testFib(0, 0);
        testFib(1, 1);
        testFib(1, 2);
        testFib(2, 3);
        testFib(3, 4);
        testFib(5, 5);
        testFib(8, 6);

        testFib(55, 10);
        testFib(610, 15);

        testFib(1134903170, 45);
    }

    @Test
    public void invalidNValues() {
        int min = 0; //inclusive
        int max = 46; //exclusive

        Random random = new Random();
        IllegalArgExTest(-1);
        IllegalArgExTest(-10);
        IllegalArgExTest(-1123);
        IllegalArgExTest(-random.nextInt(MAX_VALUE));
        IllegalArgExTest(-random.nextInt(MAX_VALUE));

        ArithmeticExTest(max);
        ArithmeticExTest(max + 1);
        ArithmeticExTest(max + 1123);
        ArithmeticExTest(max + random.nextInt(MAX_VALUE - max));
        ArithmeticExTest((random.nextInt(MAX_VALUE - max) + max));
    }

    private void testFib(int expected, int N) {
        Task4 task = new Task4();
        assertEquals(expected, task.fib(N));
    }

    private void IllegalArgExTest(int N) {
        Task4 task = new Task4();
        try {
            task.fib(N);
            fail(MESSAGE);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void ArithmeticExTest(int N) {
        Task4 task = new Task4();
        try {
            task.fib(N);
            fail(MESSAGE);
        } catch (ArithmeticException e) { /*expected*/ }
    }
}