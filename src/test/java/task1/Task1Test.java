package task1;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

/**
 * Test checks valid and invalid int x, y values including boundary values {@link Integer#MAX_VALUE}
 */
public class Task1Test {
    private static Random r = new Random();
    private static final int HALF = MAX_VALUE / 2;
    private static final String MSG = "Data must have invalid values!";

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
        testXY(0, MAX_VALUE);

        testXY(MAX_VALUE - 1, 1);
        testXY(1, MAX_VALUE - 1);


        testXY(HALF, HALF);
        testXY(-HALF, HALF);

        testXY(r.nextInt(MAX_VALUE), 0);
        testXY(0, r.nextInt(MAX_VALUE));
        testXY(r.nextInt(HALF), r.nextInt(HALF));
        testXY(-r.nextInt(HALF), -r.nextInt(HALF));
        testXY(r.nextInt(HALF), -r.nextInt(HALF));
        testXY(-r.nextInt(HALF), r.nextInt(HALF));

        testXY(MAX_VALUE, MAX_VALUE - 1);
    }

    /**
     * Checks valid x, y values and expecting success asserts
     * <p> If any Exception will be thrown test will fail</p>
     *
     * @param x int
     * @param y int
     */
    private static void testXY(int x, int y) {
        Task1 task = new Task1(x, y);
        task.inverseXY();
        assertEquals(BigInteger.valueOf(x), task.getY());
        assertEquals(BigInteger.valueOf(y), task.getX());
    }
}
