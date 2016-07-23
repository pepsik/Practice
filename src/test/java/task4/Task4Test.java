package task4;

import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

public class Task4Test {
    private static final String MSG = "Data must have invalid values!";
    private static Random r = new Random();

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
    public void testBoris(){
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
    public void invalidNValues() {
        int min = 0; //inclusive
        int max = 47; //exclusive

        illegalArgExTest(-1);
        illegalArgExTest(-10);
        illegalArgExTest(-1123);
        illegalArgExTest(-r.nextInt(MAX_VALUE));

        arithmeticExTest(max);
        arithmeticExTest(max + 1);
        arithmeticExTest(max + 1123);
        arithmeticExTest(max + 5_000);
//        arithmeticExTest(max + r.nextInt(MAX_VALUE - max)); // causes stackOverflow
//        arithmeticExTest((r.nextInt(MAX_VALUE - max) + max));
    }

    private void testFib(int expected, int N) {
        Task4 task = new Task4();
        assertEquals(expected, task.fib(N));
    }

    private void illegalArgExTest(int N) {
        Task4 task = new Task4();
        try {
            task.fib(N);
            fail(MSG);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void arithmeticExTest(int N) {
        Task4 task = new Task4();
        try {
            task.fib(N);
            fail(MSG);
        } catch (ArithmeticException e) { /*expected*/ }
    }
}