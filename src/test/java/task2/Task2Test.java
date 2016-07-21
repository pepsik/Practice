package task2;

import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task2Test {
    private static final String MSG = "Data must have invalid values!";
    private static final int HALF = MAX_VALUE / 2;
    private static Random r = new Random();


    @Test
    public void invalidValues() {
        testHouseExpectEx(-5, 20); //IllegalArgEx
        testHouseExpectEx(-1, 20);
        testHouseExpectEx(-1, 0);

        testHouseExpectEx(5, 0);
        testHouseExpectEx(0, 0);
        testHouseExpectEx(0, 5);

        testHouseExpectEx(0, -1);
        testHouseExpectEx(1, -1);
        testHouseExpectEx(1, -10);
        testHouseExpectEx(31, -101);
        testHouseExpectEx(12, -20);
        testHouseExpectEx(-r.nextInt(MAX_VALUE), 10);
        testHouseExpectEx(10, -r.nextInt(MAX_VALUE));
        testHouseExpectArithmeticEx(MAX_VALUE, MAX_VALUE);
        testHouseExpectArithmeticEx(HALF, 3);
        testHouseExpectArithmeticEx(3, HALF);
    }

    @Test
    public void validValues() {
        testHouse(1, 1, 1, 1, 1);
        testHouse(1, 1, 75, 1, 75);
        testHouse(1, 2, 75, 1, 38);

        testHouse(2, 2, 33, 1, 9);
        testHouse(2, 2, 34, 1, 9);
        testHouse(2, 2, 35, 2, 9);
        testHouse(4, 9, 1, 1, 1);
        testHouse(4, 9, 2, 1, 1);
        testHouse(4, 9, 3, 1, 1);
        testHouse(4, 9, 4, 1, 1);

        testHouse(9, 4, 36, 9, 1);
        testHouse(9, 4, 37, 1, 2);
        testHouse(9, 4, 72, 9, 2);

        testHouse(12, 2, 100, 2, 5);
        testHouse(12, 12, 144, 12, 1);
        testHouse(12, 12, 145, 1, 2);
        for (int i = 25; i <= 36; i++) {
            testHouse(12, 12, i, 3, 1);
        }

        testHouse(500, 100, 2547, 26, 1);
        testHouse(100, 10, 25471, 48, 26);
        testHouse(112, 161, 254171, 11, 15);
    }

    private void testHouseExpectEx(int floors, int apartments) {
        try {
            new Task2(floors, apartments);
            fail(MSG);
        } catch (IllegalArgumentException e) {
            /*expected*/
        }
    }

    private void testHouseExpectArithmeticEx(int floors, int apartments) {
        try {
            new Task2(floors, apartments);
            fail(MSG);
        } catch (ArithmeticException e) {
            /*expected*/
        }
    }

    private static void testHouse(int floors, int apartments, int apartmentNumber, int expectFloor, int expectEntrance) {
        Task2 task = new Task2(floors, apartments);
        assertEquals(expectEntrance, task.getEntrance(apartmentNumber));
        assertEquals(expectFloor, task.getFloor(apartmentNumber));
    }
}