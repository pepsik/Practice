package task5;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task5Test {
    private Task5 task = new Task5();
    private Random random = new Random();

    @Test
    public void invalidWeekday() {
        testWeekdayExpectEx(0);
        testWeekdayExpectEx(8);
        testWeekdayExpectEx(-random.nextInt(Integer.MAX_VALUE));
        testWeekdayExpectEx(random.nextInt(Integer.MAX_VALUE - 7) + 8);
    }

    @Test
    public void invalidMonth() {
        testMonthExpectEx(0);
        testMonthExpectEx(13);
        testMonthExpectEx(random.nextInt(Integer.MAX_VALUE - 12) + 13);
        testMonthExpectEx(-random.nextInt(Integer.MAX_VALUE));
    }

    @Test
    public void invalidDayOfMonth() {
        testDayExpectEx(32, 3);
        testDayExpectEx(29, 2);
        testDayExpectEx(32, 7);
        testDayExpectEx(32, 8);
        testDayExpectEx(31, 11);
        testDayExpectEx(32, 12);
        testDayExpectEx(-random.nextInt(Integer.MAX_VALUE), 11);
    }

    @Test
    public void validMonth() {
        testMonth(1);
        testMonth(12);
        testMonth(random.nextInt(12) + 1);
    }

    @Test
    public void validWeekday() {
        testWeekday(1);
        testWeekday(7);
        testWeekday(random.nextInt(7) + 1);
    }

    @Test
    public void validDayOfMonth() {
        testDay(28, 2);
        testDay(31, 12);
        testDay(1, 7);
        testDay(31, 7);
        testDay(31, 8);
        testDay(31, 5);
    }

    @Test
    public void validValues() {
        testExpectWeekday(17, 7, 3, 4);
        testExpectWeekday(19, 7, 5, 1);
        testExpectWeekday(20, 11, 5, 6);
        testExpectWeekday(3, 8, 5, 2);
    }

    private String failMessage(String str, int value) {
        return "Expected exception of \"" + IllegalArgumentException.class + "\" !NOT THROWN!" +
                "\n Verifying data: \n " + str + " = " + value;
    }

    private void testWeekdayExpectEx(int weekday) {
        try {
            task.setWeekdayOfNewYear(weekday);
            fail(failMessage("weekdayOfNY", weekday));
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void testWeekday(int weekday) {
        task.setWeekdayOfNewYear(weekday);
    }

    private void testMonthExpectEx(int month) {
        try {
            task.setMonth(month);
            fail(failMessage("month", month));
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void testMonth(int month) {
        task.setMonth(month);
    }

    private void testDayExpectEx(int day, int month) {
        task.setMonth(month);
        try {
            task.setDayOfMonth(day);
            fail(failMessage("day", day));
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void testDay(int day, int month) {
        task.setMonth(month);
        task.setDayOfMonth(day);
    }

    private void testExpectWeekday(int day, int month, int weekdayOfNY, int expectedWeekday) {
        task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);
        task.setWeekdayOfNewYear(weekdayOfNY);
        task.calculateWeekday();
        if (expectedWeekday != task.getCurrentWeekday())
            throw new RuntimeException("weekday WAS:" + task.getCurrentWeekday() + " but EXPECTED:" + expectedWeekday);
    }
}