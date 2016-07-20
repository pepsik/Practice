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
    private Task4 task;

    @Test
    public void validNValues() {
        assertEquals(task.fib(0), 0);
        assertEquals(task.fib(1), 1);
        assertEquals(task.fib(2), 1);
        assertEquals(task.fib(3), 2);
        assertEquals(task.fib(4), 3);
        assertEquals(task.fib(5), 5);
        assertEquals(task.fib(6), 8);

        assertEquals(task.fib(10), 55);
        assertEquals(task.fib(15), 610);

        assertEquals(task.fib(45), 1134903170);
    }

    @Test
    public void invalidNValues() {
        int min = 0; //inclusive
        int max = 46; //exclusive

        IllegalArgExTest(min - 1, "fib number can't be negative");
        ArithmeticExTest(max, "fib number can't be more than " + max + " because it causes Integer overflow");

        Random random = new Random();
        IllegalArgExTest(-(random.nextInt(MAX_VALUE - min) + min), "fib number can't be negative");
        ArithmeticExTest((random.nextInt(MAX_VALUE - max) + max), "fib number can't be more than " + max + " because it causes Integer overflow");
    }

    @Before
    public void SetUp() {
        task = new Task4();
    }

    private void IllegalArgExTest(int N, String errMsg) {
        try {
            task.fib(N);
            fail(errMsg);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void ArithmeticExTest(int N, String errMsg) {
        try {
            task.fib(N);
            fail(errMsg);
        } catch (ArithmeticException e) { /*expected*/ }
    }
}