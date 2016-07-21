package task5;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task5Test {
    private static final String MSG = "Data must have invalid values!";
    private Random r = new Random();

    @Test
    public void invalidWeekday() {
        testWeekdayExpectEx(-167);
        testWeekdayExpectEx(-10);
        testWeekdayExpectEx(-1);
        testWeekdayExpectEx(0);
        testWeekdayExpectEx(8);
        testWeekdayExpectEx(9);
        testWeekdayExpectEx(92);
        testWeekdayExpectEx(178);

        testWeekdayExpectEx(-r.nextInt(Integer.MAX_VALUE));
        testWeekdayExpectEx(r.nextInt(Integer.MAX_VALUE - 7) + 8);
    }

    @Test
    public void invalidMonth() {
        testMonthExpectEx(-160);
        testMonthExpectEx(-1);
        testMonthExpectEx(0);
        testMonthExpectEx(13);
        testMonthExpectEx(14);
        testMonthExpectEx(140);

        testMonthExpectEx(r.nextInt(Integer.MAX_VALUE - 12) + 13);
        testMonthExpectEx(-r.nextInt(Integer.MAX_VALUE));
    }

    @Test
    public void invalidDayOfMonth() {
        for (int i = 1; i <= 12; i++) {
            testDayExpectEx(0, i);
        }

        testDayExpectEx(-10, 2);
        testDayExpectEx(-60, 1);
        testDayExpectEx(-5, r.nextInt(12) + 1);
        testDayExpectEx(-r.nextInt(Integer.MAX_VALUE), 4);
        testDayExpectEx(-r.nextInt(Integer.MAX_VALUE), 11);
        testDayExpectEx(-r.nextInt(Integer.MAX_VALUE), r.nextInt(12) + 1);

        testDayExpectEx(32, 3);
        testDayExpectEx(29, 2);
        testDayExpectEx(32, 7);
        testDayExpectEx(32, 8);
        testDayExpectEx(31, 11);
        testDayExpectEx(32, 12);
    }

    @Test
    public void validMonth() {
        for (int i = 1; i <= 12; i++)
            testMonth(i);
    }

    @Test
    public void validWeekday() {
        for (int i = 1; i <= 7; i++)
            testWeekday(i);
    }

    @Test
    public void validDayOfMonth() {
        for (int i = 1; i <= 12; i++) {
            testDay(1, i);
            testDay(2, i);
            testDay(28, i);
            testDay(27, i);
        }
        testDay(31, 12);
        testDay(31, 10);
        testDay(31, 8);
        testDay(31, 7);
        testDay(31, 5);
        testDay(31, 3);
        testDay(31, 1);
    }

    @Test
    public void validValues() {
        testExpectWeekday(1, 1, 1, 1);
        testExpectWeekday(1, 1, 7, 7);
        testExpectWeekday(2, 1, 1, 2);
        testExpectWeekday(2, 1, 7, 1);
        testExpectWeekday(31, 1, 1, 3);
        testExpectWeekday(31, 1, 7, 2);
        testExpectWeekday(28, 2, 5, 7);
        testExpectWeekday(28, 2, 1, 3);
        testExpectWeekday(3, 8, 5, 2);
        testExpectWeekday(25, 8, 5, 3);
        testExpectWeekday(17, 7, 3, 4);
        testExpectWeekday(19, 7, 5, 1);
        testExpectWeekday(20, 11, 5, 6);
        testExpectWeekday(31, 12, 5, 5);
        testExpectWeekday(31, 12, 1, 1);
        testExpectWeekday(31, 12, 7, 7);
    }

    private void testWeekdayExpectEx(int weekday) {
        Task5 task = new Task5();
        try {
            task.setWeekdayOfNY(weekday);
            fail(MSG);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void testWeekday(int weekday) {
        Task5 task = new Task5();
        task.setWeekdayOfNY(weekday);
    }

    private void testMonthExpectEx(int month) {
        Task5 task = new Task5();
        try {
            task.setMonth(month);
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void testMonth(int month) {
        Task5 task = new Task5();
        task.setMonth(month);
    }

    private void testDayExpectEx(int day, int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        try {
            task.setDayOfMonth(day);
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void testDay(int day, int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);
    }

    private void testExpectWeekday(int day, int month, int weekdayOfNY, int expectedWeekday) {
        Task5 task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);
        task.setWeekdayOfNY(weekdayOfNY);
        task.calculateWeekday();
        assertEquals(expectedWeekday, task.getResultWeekday());
    }
}