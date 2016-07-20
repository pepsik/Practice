package task3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task3Test {
    private Task3 task;

    @Test
    public void validNODValues() {
        testNOD(5, 5);
        testNOD(5, 10, 5);
        testNOD(1, 5, 10, 12);
        testNOD(4, 24, 576, 20);
        testNOD(5, 55, 125, 105, 20);
    }

    @Test
    public void invalidNODValues() {
        testNODExpectEx(-1, 1);
        testNODExpectEx(0, 10, 11);
        testNODExpectEx(2, 10, -11, 56);
    }

    private void testNOD(int expectNOD, int... values) {
        task = new Task3(values);
        if (task.getNOD() != expectNOD)
            throw new RuntimeException("NOD Mismatch!! WAS: " + task.getNOD() + "\n EXPECTED:" + expectNOD);
    }

    private void testNODExpectEx(int... values) {
        try {
            task = new Task3(values);
            fail("Data must have invalid values!");
        } catch (IllegalArgumentException e) {
            /*expected*/
        }
    }
}