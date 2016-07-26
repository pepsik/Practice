package task5;

import org.junit.Test;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;

public class Task5Test {
    private static final String MSG = "Data must have invalid values!";
    private Random r = new Random();

    @Test
    public void testValidValues() {
        expectValidWeekday(1, 1, 1, 1);
        expectValidWeekday(1, 1, 7, 7); // weekday boundary value
        expectValidWeekday(2, 1, 1, 2);
        expectValidWeekday(2, 1, 7, 1);// weekday boundary value
        expectValidWeekday(31, 1, 1, 3);
        expectValidWeekday(31, 1, 7, 2); // weekday boundary value

        expectValidWeekday(27, 2, 5, 6);
        expectValidWeekday(28, 2, 5, 7);
        expectValidWeekday(25, 2, 1, 7);
        expectValidWeekday(26, 2, 1, 1); // weekday boundary value
        expectValidWeekday(27, 2, 1, 2);
        expectValidWeekday(28, 2, 1, 3);

        expectValidWeekday(1, 8, 5, 7);
        expectValidWeekday(2, 8, 5, 1); // weekday boundary value
        expectValidWeekday(3, 8, 5, 2);
        expectValidWeekday(4, 8, 5, 3);
        expectValidWeekday(25, 8, 5, 3);
        expectValidWeekday(29, 8, 5, 7);

        //weekday
        expectValidWeekday(19, 7, 1, 4);
        expectValidWeekday(19, 7, 2, 5);
        expectValidWeekday(19, 7, 3, 6);
        expectValidWeekday(19, 7, 4, 7);
        expectValidWeekday(19, 7, 5, 1); // weekday boundary value
        expectValidWeekday(19, 7, 6, 2);
        expectValidWeekday(19, 7, 7, 3);

        //months
        expectValidWeekday(20, 5, 5, 4);
        expectValidWeekday(20, 6, 5, 7);
        expectValidWeekday(20, 7, 5, 2);
        expectValidWeekday(20, 8, 5, 5);
        expectValidWeekday(20, 9, 5, 1);

        expectValidWeekday(31, 12, 1, 1);
        expectValidWeekday(31, 12, 2, 2);
        expectValidWeekday(31, 12, 3, 3);
        expectValidWeekday(31, 12, 4, 4);
        expectValidWeekday(31, 12, 5, 5);
        expectValidWeekday(31, 12, 6, 6);
        expectValidWeekday(31, 12, 7, 7);

    }

    @Test
    public void testValidMonth() {
        for (int i = 1; i <= 12; i++) {
            assertSetMonth(i);
        }

        assertEquals(Month.valueOf(1), Month.JANUARY);
        assertEquals(Month.valueOf(2), Month.FEBRUARY);
        assertEquals(Month.valueOf(3), Month.MARCH);
        assertEquals(Month.valueOf(4), Month.APRIL);
        assertEquals(Month.valueOf(5), Month.MAY);
        assertEquals(Month.valueOf(6), Month.JUNE);
        assertEquals(Month.valueOf(7), Month.JULY);
        assertEquals(Month.valueOf(8), Month.AUGUST);
        assertEquals(Month.valueOf(9), Month.SEPTEMBER);
        assertEquals(Month.valueOf(10), Month.OCTOBER);
        assertEquals(Month.valueOf(11), Month.NOVEMBER);
        assertEquals(Month.valueOf(12), Month.DECEMBER);

        assertEquals(31, Month.JANUARY.getDays());
        assertEquals(28, Month.FEBRUARY.getDays());
        assertEquals(31, Month.MARCH.getDays());
        assertEquals(30, Month.APRIL.getDays());
        assertEquals(31, Month.MAY.getDays());
        assertEquals(30, Month.JUNE.getDays());
        assertEquals(31, Month.JULY.getDays());
        assertEquals(31, Month.AUGUST.getDays());
        assertEquals(30, Month.SEPTEMBER.getDays());
        assertEquals(31, Month.OCTOBER.getDays());
        assertEquals(30, Month.NOVEMBER.getDays());
        assertEquals(31, Month.DECEMBER.getDays());
    }

    @Test
    public void testModel() {
        Task5 task = new Task5();

        assertEquals(null, task.getMonth());
        assertEquals(null, task.getWeekdayOfNY());
        assertEquals(0, task.getAllDays());

        //------test setters------
        //test weekday
        //test fields except set field
        task = new Task5();
        Weekday weekday = Weekday.valueOf(r.nextInt(Weekday.values().length) + 1);
        task.setWeekdayOfNY(weekday.index());

        assertEquals(null, task.getMonth());
        assertEquals(0, task.getAllDays());

        //test set field
        for (int i = 1; i <= 7; i++) {
            task = new Task5();
            task.setWeekdayOfNY(i);

            assertEquals(i, task.getWeekdayOfNY().index());
        }

        //set day
        //test fields except set field
        task = new Task5();
        Month month = Month.valueOf(r.nextInt(Month.values().length) + 1);
        int day = r.nextInt(month.getDays()) + 1;
        task.setMonth(month.index()); //?
        task.setDayOfMonth(day);

        assertEquals(null, task.getWeekdayOfNY());

        //set month
        //test fields except set field
        task = new Task5();
        month = Month.valueOf(r.nextInt(Month.values().length) + 1);
        task.setMonth(month.index());

        assertEquals(null, task.getWeekdayOfNY());
        assertEquals(0, task.getAllDays());


        //--------end--------

        //todo set, get in one methods
        // check state


    }

    @Test
    public void testValidWeekday() {

        assertEquals(Weekday.valueOf(1), Weekday.MONDAY);
        assertEquals(Weekday.valueOf(2), Weekday.TUESDAY);
        assertEquals(Weekday.valueOf(3), Weekday.WEDNESDAY);
        assertEquals(Weekday.valueOf(4), Weekday.THURSDAY);
        assertEquals(Weekday.valueOf(5), Weekday.FRIDAY);
        assertEquals(Weekday.valueOf(6), Weekday.SATURDAY);
        assertEquals(Weekday.valueOf(7), Weekday.SUNDAY);
    }

    @Test
    public void testValidDayOfMonth() {
        for (int i = 1; i <= 12; i++) {
            assertSetDay(1, i);
            assertSetDay(2, i);
            assertSetDay(28, i);
            assertSetDay(27, i);
        }

        assertSetDay(31, 12);
        assertSetDay(31, 10);
        assertSetDay(31, 8);
        assertSetDay(31, 7);
        assertSetDay(31, 5);
        assertSetDay(31, 3);
        assertSetDay(31, 1);

        assertSetDay(30, 4);
        assertSetDay(30, 6);
        assertSetDay(30, 9);
        assertSetDay(30, 11);
    }

    @Test
    public void testInvalidWeekday() {
        exceptionSetWeekday(-167);
        exceptionSetWeekday(-10);
        exceptionSetWeekday(-1);
        exceptionSetWeekday(0);
        exceptionSetWeekday(8);
        exceptionSetWeekday(9);
        exceptionSetWeekday(92);
        exceptionSetWeekday(178);

        exceptionEnumWeekday(0);
        exceptionEnumWeekday(-1);
        exceptionEnumWeekday(-5);
        exceptionEnumWeekday(-512);
        exceptionEnumWeekday(-r.nextInt(MAX_VALUE));

        exceptionEnumWeekday(8);
        exceptionEnumWeekday(9);
        exceptionEnumWeekday(123);
        exceptionEnumWeekday(r.nextInt(MAX_VALUE - 7) + 8);

        exceptionSetWeekday(-r.nextInt(MAX_VALUE));
        exceptionSetWeekday(r.nextInt(MAX_VALUE - 7) + 8);
    }

    @Test
    public void testInvalidMonth() {
        exceptionSetMonth(-160);
        exceptionSetMonth(-1);
        exceptionSetMonth(0);
        exceptionSetMonth(13);
        exceptionSetMonth(14);
        exceptionSetMonth(140);

        exceptionEnumMonth(0);
        exceptionEnumMonth(-1);
        exceptionEnumMonth(-2);
        exceptionEnumMonth(-3);
        exceptionEnumMonth(-150);
        exceptionEnumMonth(-r.nextInt(MAX_VALUE));

        exceptionEnumMonth(13);
        exceptionEnumMonth(14);
        exceptionEnumMonth(145);
        exceptionEnumMonth(r.nextInt(MAX_VALUE - 12) + 13);

        exceptionSetMonth(r.nextInt(MAX_VALUE - 12) + 13);
        exceptionSetMonth(-r.nextInt(MAX_VALUE));
    }

    @Test
    public void testInvalidDayOfMonth() {
        for (int i = 1; i <= 12; i++) {
            exceptionSetDay(0, i);
        }

        exceptionSetDay(-10, 2);
        exceptionSetDay(-60, 1);
        exceptionSetDay(-5, r.nextInt(12) + 1);
        exceptionSetDay(-r.nextInt(MAX_VALUE), 4);
        exceptionSetDay(-r.nextInt(MAX_VALUE), 11);
        exceptionSetDay(-r.nextInt(MAX_VALUE), r.nextInt(12) + 1);

        exceptionSetDay(32, 3);
        exceptionSetDay(29, 2);
        exceptionSetDay(32, 7);
        exceptionSetDay(32, 8);
        exceptionSetDay(31, 11);
        exceptionSetDay(32, 12);
    }

    private void assertSetMonth(int month) {
        Task5 task = new Task5();
        task.setMonth(month);

        int allDays = task.getAllDays();
        Weekday weekday = task.getWeekdayOfNY();

        assertEquals(weekday, task.getWeekdayOfNY());
        assertEquals(allDays, task.getAllDays());
        assertEquals(month, task.getMonth().index());
    }

    private void assertSetDay(int day, int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);
        int allDays = task.getAllDays();
        Weekday weekday = task.getWeekdayOfNY();

        assertEquals(weekday, task.getWeekdayOfNY());
        assertEquals(allDays, task.getAllDays());
        assertEquals(month, task.getMonth().index());
    }

    private void exceptionSetWeekday(int weekday) {
        Task5 task = new Task5();
        try {
            task.setWeekdayOfNY(weekday);
            fail(MSG);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void exceptionSetMonth(int month) {
        Task5 task = new Task5();
        try {
            task.setMonth(month);
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void exceptionSetDay(int day, int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        try {
            task.setDayOfMonth(day);
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void exceptionEnumWeekday(int i) {
        try {
            Weekday.valueOf(i);
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void exceptionEnumMonth(int i) {
        try {
            Month.valueOf(i);
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void expectValidWeekday(int day, int month, int weekdayOfNY, int expectedWeekday) {
        Task5 task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);
        task.setWeekdayOfNY(weekdayOfNY);
        task.calculateWeekday();

        assertEquals(expectedWeekday, task.getResultWeekday());
    }
}