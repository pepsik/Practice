package task2;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/20/2016.
 */
public class Task2Test {
    private Task2 task;

    @Test
    public void invalidValues() {
        Random random = new Random();
        testHouseExpectEx(-5, 20);
        testHouseExpectEx(5, -10);
        testHouseExpectEx(0, 20);
        testHouseExpectEx(5, 0);
        testHouseExpectEx(-random.nextInt(Integer.MAX_VALUE), 10);
        testHouseExpectEx(10, -random.nextInt(Integer.MAX_VALUE));
        testHouseExpectArithmeticEx(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void validValues() {
        testHouse(1, 1, 75, 1, 75);
        testHouse(4, 9, 1, 1, 1);
        testHouse(9, 4, 36, 9, 1);
        testHouse(9, 4, 37, 1, 2);
        testHouse(9, 4, 72, 9, 2);
    }

    private void testHouseExpectEx(int floors, int apartments) {
        try {
            task = new Task2(floors, apartments);
            fail("Data must have invalid values!");
        } catch (IllegalArgumentException e) {
            /*expected*/
        }
    }

    private void testHouseExpectArithmeticEx(int floors, int apartments) {
        try {
            task = new Task2(floors, apartments);
            fail("Data must have invalid values!");
        } catch (ArithmeticException e) {
            /*expected*/
        }
    }

    private void testHouse(int floors, int apartments, int apartmentNumber, int expectFloor, int expectEntrance) {
        task = new Task2(floors, apartments);
        if (task.getEntrance(apartmentNumber) != expectEntrance)
            throw new RuntimeException("Entrance Mismatch!! WAS:" + task.getEntrance(apartmentNumber) + "\n EXPECT:" + expectEntrance);
        if (task.getFloor(apartmentNumber) != expectFloor)
            throw new RuntimeException("Floor Mismatch!! WAS:" + task.getFloor(apartmentNumber) + "\n EXPECT:" + expectFloor);

    }
}