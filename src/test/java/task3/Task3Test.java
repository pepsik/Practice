package task3;

import org.junit.Test;

import java.util.Arrays;
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
        //random 1 value
        testNOD(1, 1);
        testNOD(112, 112);
        testNOD(151, 151);
        testNOD(51, 51);
        testNOD(24, 24);
        for (int i = 1; i < 100; i++) {
            int randVal = r.nextInt(MAX_VALUE);
            testNOD(randVal, randVal);
        }

        //random 2 values
        testNOD(1, 10, 1);
        testNOD(1, 1, 10);
        testNOD(10, 120, 10);
        testNOD(10, 1, 120);
        testNOD(11, 121, 11);
        testNOD(11, 11, 121);
        testNOD(5, 10, 5);
        testNOD(5, 5, 10);
        testNOD(2, 10, 52);
        testNOD(1, 13, 25);
        testNOD(1, 25, 13);
        testNOD(10, 50, 120);
        testNOD(10, 120, 50);
        for (int i = 1; i < 100; i++) {
            int randValue = r.nextInt(MAX_VALUE);
            testNOD(randValue, randValue, randValue);
        }

        //symmetric values
        for (int i = 1; i < 100; i++) {
            testNOD(1, 113, i);
            testNOD(1, i, 113);
            testNOD(i, i, i);
            testNOD(1, 211, i, i);
            testNOD(1, i, i, 211);
        }

        //prime numbers
        for (int i = 1; i < 100; i++) {
            testNOD(1, 113, r.nextInt(112) + 1);
            testNOD(1, 211, r.nextInt(210) + 1, r.nextInt(210) + 1);
            testNOD(1, 17, r.nextInt(16) + 1, r.nextInt(16) + 1 + 17);
            testNOD(1, 211, i, i + 10, i + 20, i + 30);

            int[] arr = new int[i + 1];
            arr[0] = 211;
            Arrays.fill(arr, 1, i + 1, i);
            testNOD(1, arr);
        }

        //random 3 values
        testNOD(1, 5, 10, 12);
        testNOD(1, 113, 124124, 14);
        testNOD(4, 24, 576, 20);
        testNOD(11, 11, 121, 22);
        testNOD(4, 124, 44, 112);

        //random 4 values
        testNOD(5, 55, 125, 105, 20);
        testNOD(24, 24, 120, 360, 144);
        testNOD(24, 144, 360, 120, 24);

        //identical values
        testNOD(14, 14, 14);
        testNOD(55, 55, 55, 55, 55, 55);
        for (int i = 1; i < 100; i++) {
            int[] arr = new int[i];
            Arrays.fill(arr, i);
            testNOD(i, arr);
        }

        //checks boundary values
        for (int i = 1; i < 100; i++) {
            int[] arr = new int[i];
            Arrays.fill(arr, MAX_VALUE);
            testNOD(MAX_VALUE, arr);

            int[] arr2 = new int[i + 1];
            arr2[0] = 13;
            Arrays.fill(arr2, 1, i + 1, MAX_VALUE);
            testNOD(1, arr2);
        }
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