package task4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task4Test {
    private Task4 task;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void SetUp() {
        task = new Task4();
    }

    @Test
    public void validNValues() {
        assertTrue(task.fib(0) == 0);
        assertTrue(task.fib(1) == 1);
        assertTrue(task.fib(2) == 1);
        assertTrue(task.fib(3) == 2);
        assertTrue(task.fib(4) == 3);
        assertTrue(task.fib(5) == 5);
        assertTrue(task.fib(6) == 8);
        assertTrue(task.fib(10) == 55);
        assertTrue(task.fib(15) == 610);
        assertTrue(task.fib(45) == 1134903170);
    }

    @Test
    public void invalidNLessZeroValues() {
        exception.expect(IllegalArgumentException.class);
        task.fib(-1);
        exception.expect(IllegalArgumentException.class);
        System.out.println(1);
        task.fib(200);
    }

    @Test(expected = ArithmeticException.class)
    public void invalidFibNumberMoreIntegerMaxValue() {
        task.fib(200);
    }

}