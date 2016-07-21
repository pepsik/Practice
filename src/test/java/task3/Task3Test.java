package task3;

import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task3Test {
    private static Random r = new Random();
    private static final String MSG = "Data must have invalid values!";

    @Test
    public void validNODValues() {
        testNOD(1, 1);
        testNOD(112, 112);
        testNOD(151, 151);
        testNOD(51, 51);
        testNOD(24, 24);

        testNOD(1, 10, 1);
        testNOD(5, 10, 5);
        testNOD(2, 10, 52);
        testNOD(14, 14, 14);

        for (int i = 1; i < 100; i++) {
            testNOD(1, 113, r.nextInt(112) + 1);
            testNOD(1, 211, r.nextInt(210) + 1, r.nextInt(210) + 1);
            testNOD(1, 17, r.nextInt(16) + 1, r.nextInt(16) + 1 + 17);
        }

        testNOD(1, 5, 10, 12);
        testNOD(4, 24, 576, 20);

        testNOD(5, 55, 125, 105, 20);
        testNOD(24, 24, 120, 360, 144);
        testNOD(24, 144, 360, 120, 24);
        testNOD(55, 55, 55, 55, 55, 55);
    }

    @Test
    public void invalidNODValues() {
        testNODExpectEx(0);
        testNODExpectEx(-1);
        testNODExpectEx(-99);
        testNODExpectEx(-r.nextInt(MAX_VALUE));

        testNODExpectEx(0, 0);
        testNODExpectEx(0, 1);
        testNODExpectEx(-1, 1);
        testNODExpectEx(-r.nextInt(MAX_VALUE), 1);

        testNODExpectEx(-1, r.nextInt(MAX_VALUE));
        testNODExpectEx(0, 10, 11);
        testNODExpectEx(2, 10, -11, 56);
    }

    private void testNOD(int expectNOD, int... values) {
        Task3 task = new Task3(values);
        assertEquals(expectNOD, task.getNOD());
    }

    private void testNODExpectEx(int... values) {
        try {
            new Task3(values);
            fail(MSG);
        } catch (IllegalArgumentException e) {
            /*expected*/
        }
    }
}