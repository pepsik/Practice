package task2;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task2Test {
    private static final String MSG = "Data must have invalid values!";

    @Test
    public void invalidValues() {
        Random random = new Random();
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
        testHouseExpectEx(-random.nextInt(Integer.MAX_VALUE), 10);
        testHouseExpectEx(10, -random.nextInt(Integer.MAX_VALUE));
        testHouseExpectArithmeticEx(Integer.MAX_VALUE, Integer.MAX_VALUE);
        testHouseExpectArithmeticEx(Integer.MAX_VALUE / 2, 3);
        testHouseExpectArithmeticEx(3, Integer.MAX_VALUE / 2);
    }

    @Test
    public void validValues() {
        testHouse(1, 1, 1, 1, 1);
        testHouse(1, 1, 75, 1, 75);
        testHouse(1, 2, 75, 1, 38);

        testHouse(2, 2, 33, 1, 9);
        testHouse(4, 9, 1, 1, 1);

        testHouse(9, 4, 36, 9, 1);
        testHouse(9, 4, 37, 1, 2);
        testHouse(9, 4, 72, 9, 2);

        testHouse(12, 2, 100, 2, 5);
        testHouse(12, 12, 144, 12, 1);
        testHouse(12, 12, 145, 1, 2);

        testHouse(500, 100, 2547, 26, 1);
    }

    private void testHouseExpectEx(int floors, int apartments) {
        try {
            Task2 task = new Task2(floors, apartments);
            fail(MSG);
        } catch (IllegalArgumentException e) {
            /*expected*/
        }
    }

    private void testHouseExpectArithmeticEx(int floors, int apartments) {
        try {
            Task2 task = new Task2(floors, apartments);
            fail(MSG);
        } catch (ArithmeticException e) {
            /*expected*/
        }
    }

    private void testHouse(int floors, int apartments, int apartmentNumber, int expectFloor, int expectEntrance) {
        Task2 task = new Task2(floors, apartments);
        assertEquals(expectEntrance, task.getEntrance(apartmentNumber));
        assertEquals(expectFloor, task.getFloor(apartmentNumber));
    }
}