package task1;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static java.math.BigInteger.valueOf;
import static org.junit.Assert.*;

/**
 * Test checks valid and invalid int x, y values including boundary values {@link Integer#MAX_VALUE}
 */
public class Task1Test {
    private static Random r = new Random();
    private static final int HALF = MAX_VALUE / 2;
    private static final String MSG = "Data must have invalid values!";

    @Test
    public void testValidValues() {
        testSwapIntXY(1541, 0);
        testSwapIntXY(1, 0);
        testSwapIntXY(-1, 0);
        testSwapIntXY(-124, 0);
        testSwapIntXY(-12324, 0);

        testSwapIntXY(0, 0);
        testSwapIntXY(0, 12389);
        testSwapIntXY(0, 1);
        testSwapIntXY(0, -1);
        testSwapIntXY(0, -111);
        testSwapIntXY(0, -112311);

        testSwapIntXY(1, 1);
        testSwapIntXY(1, 2);
        testSwapIntXY(1, 51);
        testSwapIntXY(1, 2123);
        testSwapIntXY(2, 1);
        testSwapIntXY(1242, 1);

        testSwapIntXY(-1, 1);
        testSwapIntXY(-11, 13);
        testSwapIntXY(-1241, 1213);

        testSwapIntXY(1, -1);
        testSwapIntXY(121, -1124);
        testSwapIntXY(1268, -11994);

        testSwapIntXY(-1, -1);
        testSwapIntXY(-123, -1);
        testSwapIntXY(-11254, -1);
        testSwapIntXY(-1, -1213);

        testSwapIntXY(MAX_VALUE, 0);
        testSwapIntXY(0, MAX_VALUE);

        testSwapIntXY(MAX_VALUE - 1, 1);
        testSwapIntXY(1, MAX_VALUE - 1);

        testSwapIntXY(HALF, HALF);
        testSwapIntXY(-HALF, HALF);

        testSwapIntXY(r.nextInt(MAX_VALUE), 0);
        testSwapIntXY(0, r.nextInt(MAX_VALUE));
        testSwapIntXY(r.nextInt(HALF), r.nextInt(HALF));
        testSwapIntXY(-r.nextInt(HALF), -r.nextInt(HALF));
        testSwapIntXY(r.nextInt(HALF), -r.nextInt(HALF));
        testSwapIntXY(-r.nextInt(HALF), r.nextInt(HALF));

        testSwapIntXY(MAX_VALUE, MAX_VALUE - 1);
        testSwapIntXY(MAX_VALUE - 1, MAX_VALUE);

        testSwapBigIntXY(valueOf(0), valueOf(0));
        testSwapBigIntXY(valueOf(1), valueOf(1));
        testSwapBigIntXY(valueOf(1), valueOf(2));

        BigInteger positiveBI = new BigInteger("1234567890123");
        BigInteger negativeBI = new BigInteger("-1234567890123");

        testSwapBigIntXY(positiveBI, valueOf(1));
        testSwapBigIntXY(positiveBI, valueOf(-1));
        testSwapBigIntXY(negativeBI, valueOf(1));
        testSwapBigIntXY(negativeBI, valueOf(1));

        testSwapBigIntXY(valueOf(1), positiveBI);
        testSwapBigIntXY(valueOf(-1), positiveBI);
        testSwapBigIntXY(valueOf(1), negativeBI);
        testSwapBigIntXY(valueOf(1), negativeBI);

        testSwapBigIntXY(negativeBI, negativeBI);
        testSwapBigIntXY(positiveBI, negativeBI);
        testSwapBigIntXY(negativeBI, positiveBI);
        testSwapBigIntXY(positiveBI, positiveBI);

        for (int i = 1; i < 10; i++) {
            positiveBI = new BigInteger("1234567890" + r.nextInt(MAX_VALUE) + r.nextInt(MAX_VALUE));
            negativeBI = new BigInteger("-1234567890" + r.nextInt(MAX_VALUE) + r.nextInt(MAX_VALUE));

            testSwapBigIntXY(valueOf(1), positiveBI);
            testSwapBigIntXY(valueOf(-1), positiveBI);
            testSwapBigIntXY(valueOf(1), negativeBI);
            testSwapBigIntXY(valueOf(1), negativeBI);

            testSwapBigIntXY(negativeBI, negativeBI);
            testSwapBigIntXY(positiveBI, negativeBI);
            testSwapBigIntXY(negativeBI, positiveBI);
            testSwapBigIntXY(positiveBI, positiveBI);
        }
    }

    /**
     * Checks valid int x, y values and expecting success asserts
     *
     * @param x int
     * @param y int
     */
    private static void testSwapIntXY(int x, int y) {
        Task1 task = new Task1(valueOf(x), (valueOf(y)));
        task.inverseXY();
        assertEquals(valueOf(x), task.getY());
        assertEquals(valueOf(y), task.getX());
    }

    /**
     * Checks valid BigInteger x, y values and expecting success asserts
     *
     * @param x int
     * @param y int
     */
    private static void testSwapBigIntXY(BigInteger x, BigInteger y) {
        Task1 task = new Task1(x, y);
        task.inverseXY();
        assertEquals(x, task.getY());
        assertEquals(y, task.getX());
    }
}
