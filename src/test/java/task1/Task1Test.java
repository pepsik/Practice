package task1;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task1Test {
    private Task1 task = new Task1();

    @Test
    public void invalidValues() {
        testXYExpectEx(MAX_VALUE / 2, MAX_VALUE / 2 + 2);
        testXYExpectEx(-MAX_VALUE / 2, -MAX_VALUE / 2 - 2);
    }

    @Test
    public void validValues() {
        testXY(10, 5);
        testXY(1, 51);
        testXY(-11, 0);
        testXY(-5, -5);
        testXY(54, -5);
        testXY(MAX_VALUE / 2, MAX_VALUE / 2 - 1);
        testXY(-MAX_VALUE / 2, MAX_VALUE / 2 - 1);
    }

    private void testXYExpectEx(int x, int y) {
        task.setXY(x, y);
        try {
            task.inverseXY();
            fail("Data must have invalid values!");
        } catch (ArithmeticException e) {
            /*expected*/
        }
    }

    private void testXY(int x, int y) {
        task.setXY(x, y);
        task.inverseXY();
        if (x != task.getY() || y != task.getX())
            throw new RuntimeException("XY Mismatch!! WAS: x=" + task.getX() + " y=" + task.getY() +
                    "\n EXPECT: x=" + y + " y=" + x);
    }
}
