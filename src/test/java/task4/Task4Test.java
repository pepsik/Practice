package task4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task4Test {
    private Task4 task;
    private Random random;
    private final int leftBorderValidN = 0; //inclusive
    private final int rightBorderValidN = 46; //exclusive

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void SetUp() {
        task = new Task4();
        random = new Random();
    }

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
    public void invalidN() {
        try {
            task.fib(leftBorderValidN - 1);
            fail("fib number can't be negative");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.fib(rightBorderValidN + 1);
            fail("fib number can't be more than " + rightBorderValidN + " because it causes Integer overflow");
        } catch (Exception e) {
            assertThat(e, instanceOf(ArithmeticException.class));
        }
        try {
            task.fib((random.nextInt(Integer.MAX_VALUE - leftBorderValidN) + leftBorderValidN) * -1); //0 is valid N therefore + 1
            fail("fib number can't be negative");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.fib((random.nextInt(Integer.MAX_VALUE - rightBorderValidN) + rightBorderValidN));
            fail("fib number can't be more than " + rightBorderValidN + " because it causes Integer overflow");
        } catch (Exception e) {
            assertThat(e, instanceOf(ArithmeticException.class));
        }
    }
}