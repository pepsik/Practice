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
    public void testValidValues() {
        testResultValue(1, 1, 1, 1, 1);
        testResultValue(1, 1, 2, 1, 2);
        for (int i = 1; i < 100; i++) {
            int value = r.nextInt(MAX_VALUE);
            testResultValue(1, 1, value, 1, value);
        }

        testResultValue(1, 2, 1, 1, 1);
        testResultValue(1, 2, 2, 1, 1);
        testResultValue(1, 2, 3, 1, 2); //checks entrance boundary value
        testResultValue(1, 2, 4, 1, 2);
        testResultValue(1, 2, 5, 1, 3); //checks entrance boundary value
        testResultValue(1, 2, 6, 1, 3);
        testResultValue(1, 2, 99, 1, 50);
        testResultValue(1, 2, 100, 1, 50);
        testResultValue(1, 2, 101, 1, 51); //checks entrance boundary value
        testResultValue(1, 2, 102, 1, 51);
        testResultValue(1, 2, 103, 1, 52); //checks entrance boundary value
        testResultValue(1, 2, 104, 1, 52);

        testResultValue(2, 2, 32, 2, 8);
        testResultValue(2, 2, 33, 1, 9); //checks floor and entrance boundary values
        testResultValue(2, 2, 34, 1, 9);
        testResultValue(2, 2, 35, 2, 9);  //checks floor boundary value
        testResultValue(2, 2, 36, 2, 9);
        testResultValue(2, 2, 37, 1, 10); //checks floor and entrance boundary values
        testResultValue(2, 2, 38, 1, 10);

        //
        testResultValue(4, 9, 1, 1, 1);
        testResultValue(4, 9, 2, 1, 1);
        testResultValue(4, 9, 9, 1, 1);
        testResultValue(4, 9, 10, 2, 1); //checks floor boundary value
        testResultValue(4, 9, 11, 2, 1);
        testResultValue(4, 9, 35, 4, 1); //checks floor boundary value
        testResultValue(4, 9, 36, 4, 1);
        testResultValue(4, 9, 37, 1, 2); //checks and entrance entrance boundary values
        testResultValue(4, 9, 38, 1, 2);

        testResultValue(9, 4, 35, 9, 1);
        testResultValue(9, 4, 36, 9, 1);
        testResultValue(9, 4, 37, 1, 2);    //checks floor and entrance boundary values
        testResultValue(9, 4, 38, 1, 2);
        testResultValue(9, 4, 40, 1, 2);
        testResultValue(9, 4, 41, 2, 2);   //checks entrance boundary value
        testResultValue(9, 4, 42, 2, 2);
        testResultValue(9, 4, 72, 9, 2);    //checks floor boundary value
        testResultValue(9, 4, 73, 1, 3);      //checks floor and entrance boundary values

        //
        testResultValue(12, 2, 95, 12, 4);
        testResultValue(12, 2, 96, 12, 4);
        testResultValue(12, 2, 97, 1, 5);  //checks floor and entrance boundary values
        testResultValue(12, 2, 100, 2, 5);  //checks floor boundary value
        testResultValue(12, 2, 101, 3, 5); //checks floor boundary value
        testResultValue(12, 2, 119, 12, 5); //checks floor  boundary value
        testResultValue(12, 2, 120, 12, 5);
        testResultValue(12, 2, 121, 1, 6);  //checks floor and entrance boundary values
        testResultValue(12, 2, 122, 1, 6);

        testResultValue(12, 12, 144, 12, 1);
        testResultValue(12, 12, 145, 1, 2); //checks floor and entrance boundary values
        //checks all apartments on floor
        for (int i = 25; i <= 36; i++) {
            testResultValue(12, 12, i, 3, 1);
        }

        //checks floor boundary value
        testResultValue(100, 1, 1, 1, 1);
        testResultValue(100, 1, 2, 2, 1);
        for (int i = 3; i < 98; i++) {
            testResultValue(100, 1, i, i, 1);
        }
        testResultValue(100, 1, 99, 99, 1);
        testResultValue(100, 1, 100, 100, 1);
        testResultValue(100, 1, 101, 1, 2);
        testResultValue(100, 1, 102, 2, 2);

        //checks entrance boundary value
        testResultValue(1, 100, 1, 1, 1);
        testResultValue(1, 100, 2, 1, 1);
        for (int i = 3; i < 98; i++) {
            testResultValue(1, 100, i, 1, 1);
        }
        testResultValue(1, 100, 99, 1, 1);
        testResultValue(1, 100, 100, 1, 1);
        testResultValue(1, 100, 101, 1, 2);
        testResultValue(1, 100, 102, 1, 2);
        testResultValue(1, 100, 200, 1, 2);
        testResultValue(1, 100, 201, 1, 3);
        testResultValue(1, 100, 202, 1, 3);
        testResultValue(1, 100, 300, 1, 3);
        testResultValue(1, 100, 301, 1, 4);

        testResultValue(100, 10, 25471, 48, 26);
        testResultValue(100, 10, 25499, 50, 26);
        testResultValue(100, 10, 25500, 50, 26);
        testResultValue(100, 10, 25501, 51, 26);
        testResultValue(100, 10, 25502, 51, 26);

        testResultValue(500, 100, 50000, 500, 1);
        testResultValue(500, 100, 50001, 1, 2); //checks floor and entrance boundary values
        for (int i = 1; i < 100; i++) {
            testResultValue(500, 100, 50000 + i, 1, 2);
        }
        testResultValue(500, 100, 50101, 2, 2); //checks floor boundary values
        testResultValue(500, 100, 50102, 2, 2);

        for (int i = 1; i < 100; i++) {
            testResultValue(i, 10, 1, 1, 1);
            testResultValue(10, i, 1, 1, 1);
        }
        for (int i = 5; i < 100; i++) {
            testResultValue(i, 10, 5, 1, 1);
            testResultValue(10, i, 5, 1, 1);
        }
    }

    @Test
    public void testInvalidValues() {
        testIllegalArgEx(-5, 20);
        testIllegalArgEx(-1, 20);
        testIllegalArgEx(-1, 0);

        testIllegalArgEx(5, 0);
        testIllegalArgEx(0, 0);
        testIllegalArgEx(0, 5);

        testIllegalArgEx(0, -1);
        testIllegalArgEx(1, -1);
        testIllegalArgEx(1, -10);
        testIllegalArgEx(31, -101);
        testIllegalArgEx(12, -20);
        testIllegalArgEx(-r.nextInt(MAX_VALUE), 10);
        testIllegalArgEx(10, -r.nextInt(MAX_VALUE));
        testArithmeticEx(MAX_VALUE, MAX_VALUE);
        testArithmeticEx(HALF, 3);
        testArithmeticEx(3, HALF);
    }

    private void testIllegalArgEx(int floors, int apartmentsPerFloor) {
        try {
            new Task2(floors, apartmentsPerFloor);
            fail(MSG);
        } catch (IllegalArgumentException e) {
            /*expected*/
        }
    }

    private void testArithmeticEx(int floors, int apartmentsPerFloor) {
        try {
            new Task2(floors, apartmentsPerFloor);
            fail(MSG);
        } catch (ArithmeticException e) {
            /*expected*/
        }
    }

    private static void testResultValue(int floors, int apartments, int apartmentNumber, int expectFloor, int expectEntrance) {
        Task2 task = new Task2(floors, apartments);
        assertEquals(expectEntrance, task.getEntrance(apartmentNumber));
        assertEquals(expectFloor, task.getFloor(apartmentNumber));
    }
}