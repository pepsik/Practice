package task4;

import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

public class Task4Test {
    private static final String MSG = "Data must have invalid values!";
    private static Random r = new Random();

    @Test
    public void testValidNValues() {
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
    public void testBoris() {
        Task4 task = new Task4();

        assertEquals(3, task.fib(4));
        assertEquals(3, task.fib(4));
        assertEquals(5, task.fib(5));
        assertEquals(5, task.fib(5));
        assertEquals(8, task.fib(6));
        assertEquals(3, task.fib(4));
        assertEquals(8, task.fib(6));
        assertEquals(55, task.fib(10));
        assertEquals(3, task.fib(4));
        assertEquals(1, task.fib(2));
        assertEquals(1836311903, task.fib(46));
        assertEquals(1, task.fib(2));
    }

    @Test
    public void testInvalidNValues() {
        int min = 0; //inclusive
        int max = 46; //exclusive

        testIllegalArgEx(-1);
        testIllegalArgEx(-10);
        testIllegalArgEx(-1123);
        testIllegalArgEx(-r.nextInt(MAX_VALUE));

        testIllegalArgEx(max + 1);
        testIllegalArgEx(max + 2);
        testIllegalArgEx(max + 100);
        testIllegalArgEx(max + 2000);
        testIllegalArgEx(max + 5200);
        testIllegalArgEx(max + 10000);
        testIllegalArgEx(max + r.nextInt(MAX_VALUE - max));
    }

    private void testFib(int expected, int N) {
        Task4 task = new Task4();
        assertEquals(expected, task.fib(N));
    }

    private void testIllegalArgEx(int N) {
        Task4 task = new Task4();
        try {
            task.fib(N);
            fail(MSG);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }
}