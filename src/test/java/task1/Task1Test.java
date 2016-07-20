package task1;

import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task1Test {

    @Test
    public void invalidValues() {
        Random random = new Random();
        testXYExpectEx(MAX_VALUE, 1);
        testXYExpectEx(1, MAX_VALUE);
        testXYExpectEx(MAX_VALUE, random.nextInt(MAX_VALUE));
        testXYExpectEx(random.nextInt(MAX_VALUE), MAX_VALUE);

        testXYExpectEx(-MAX_VALUE, MAX_VALUE);
        testXYExpectEx(MAX_VALUE, -MAX_VALUE);
        testXYExpectEx(MAX_VALUE / 2, MAX_VALUE / 2 + 2);
        testXYExpectEx(-MAX_VALUE / 2, -MAX_VALUE / 2 - 2);

        int temp1 = random.nextInt(MAX_VALUE), temp2 = MAX_VALUE - temp1 + 1;
        testXYExpectEx(temp1, temp2);
        testXYExpectEx(temp2, temp1);

        temp1 = -random.nextInt(MAX_VALUE);
        temp2 = MAX_VALUE + temp1 + 1;
        testXYExpectEx(temp1, temp2);
        testXYExpectEx(temp2, temp1);
    }

    @Test
    public void validValues() {
        testXY(1541, 0);
        testXY(1, 0);
        testXY(-1, 0);
        testXY(-124, 0);
        testXY(-12324, 0);

        testXY(0, 0);
        testXY(0, 12389);
        testXY(0, 1);
        testXY(0, -1);
        testXY(0, -111);
        testXY(0, -112311);

        testXY(1, 1);
        testXY(1, 2);
        testXY(1, 51);
        testXY(1, 2123);
        testXY(2, 1);
        testXY(1242, 1);

        testXY(-1, 1);
        testXY(-11, 13);
        testXY(-1241, 1213);

        testXY(1, -1);
        testXY(121, -1124);
        testXY(1268, -11994);

        testXY(-1, -1);
        testXY(-123, -1);
        testXY(-11254, -1);
        testXY(-1, -1213);

        testXY(MAX_VALUE, 0);
        testXY(MAX_VALUE - 1, 1);
        testXY(0, MAX_VALUE);
        testXY(1, MAX_VALUE - 1);
        testXY(MAX_VALUE / 2, MAX_VALUE / 2);
        testXY(-MAX_VALUE / 2, MAX_VALUE / 2);

        Random random = new Random();
        testXY(random.nextInt(MAX_VALUE), 0);
        testXY(0, random.nextInt(MAX_VALUE));
        testXY(random.nextInt(MAX_VALUE / 2), random.nextInt(MAX_VALUE / 2));
        testXY(-random.nextInt(MAX_VALUE / 2), -random.nextInt(MAX_VALUE / 2));
        testXY(random.nextInt(MAX_VALUE / 2), -random.nextInt(MAX_VALUE / 2));
        testXY(-random.nextInt(MAX_VALUE / 2), random.nextInt(MAX_VALUE / 2));
    }

    private void testXYExpectEx(int x, int y) {
        try {
            Task1 task = new Task1(x, y);
            fail("Data must have invalid values!");
        } catch (ArithmeticException e) {
            /*expected*/
        }
    }

    private void testXY(int x, int y) {
        Task1 task = new Task1(x, y);
        task.inverseXY();
        assertEquals(x, task.getY());
        assertEquals(y, task.getX());
    }
}
