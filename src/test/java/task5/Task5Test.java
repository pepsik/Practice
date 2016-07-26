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
    public void testModel() {
        //test new obj
        Task5 task = new Task5();

        assertEquals(0, task.getMonth());
        assertEquals(0, task.getWeekdayOfNY());
        assertEquals(0, task.getDay());


        //------test setters------
        //set weekday
        task = new Task5();
        task.setWeekdayOfNY(7);

        assertEquals(0, task.getMonth());
        assertEquals(7, task.getWeekdayOfNY());
        assertEquals(0, task.getDay());

        //set day
        task = new Task5();
        task.setDayOfMonth(28);

        assertEquals(0, task.getMonth());
        assertEquals(0, task.getWeekdayOfNY());
        assertEquals(28, task.getDay());

        //set month
        task = new Task5();
        task.setMonth(2);

        assertEquals(2, task.getMonth());
        assertEquals(0, task.getWeekdayOfNY());
        assertEquals(0, task.getDay());


        //new
        //test setters with one common object using known 3 input values (day, month, weekday)
        //set weekday
        Task5 commonTask = new Task5(); //common obj
        int testWeekday = 7;
        commonTask.setWeekdayOfNY(testWeekday);

        assertEquals(0, commonTask.getMonth());
        assertEquals(testWeekday, commonTask.getWeekdayOfNY());
        assertEquals(0, commonTask.getDay());

        //set day
        int testDay = 28;
        commonTask.setDayOfMonth(testDay);

        assertEquals(0, commonTask.getMonth());
        assertEquals(testWeekday, commonTask.getWeekdayOfNY());
        assertEquals(testDay, commonTask.getDay());

        //set month
        int testMonth = 2;
        commonTask.setMonth(testMonth);

        assertEquals(testMonth, commonTask.getMonth());
        assertEquals(testWeekday, commonTask.getWeekdayOfNY());
        assertEquals(testDay, commonTask.getDay());


        //independent setter tests with one common object using only one known SET value (day or month or weekday)
        //set weekday
        int inputWeekday = 7; //known value
        int existMonth = commonTask.getMonth();
        int existDay = commonTask.getDay();
        commonTask.setWeekdayOfNY(inputWeekday);

        assertEquals(inputWeekday, commonTask.getWeekdayOfNY());
        assertEquals(existMonth, commonTask.getMonth());
        assertEquals(existDay, commonTask.getDay());

        //set day
        int inputDay = 28;
        int existWeekday = commonTask.getWeekdayOfNY();
        existMonth = commonTask.getMonth();
        commonTask.setDayOfMonth(inputDay);

        assertEquals(inputDay, commonTask.getDay());
        assertEquals(existMonth, commonTask.getMonth());
        assertEquals(existWeekday, commonTask.getWeekdayOfNY());

        //set month
        int inputMonth = 2;
        existDay = commonTask.getDay();
        existWeekday = commonTask.getWeekdayOfNY();
        commonTask.setMonth(inputMonth);

        assertEquals(inputMonth, commonTask.getMonth());
        assertEquals(existDay, commonTask.getDay());
        assertEquals(existWeekday, commonTask.getWeekdayOfNY());

        //--------end--------


        //test set all weekdays
        assertSetWeekdayOfNY(1);
        assertSetWeekdayOfNY(2);
        assertSetWeekdayOfNY(3);
        assertSetWeekdayOfNY(4);
        assertSetWeekdayOfNY(5);
        assertSetWeekdayOfNY(6);
        assertSetWeekdayOfNY(7);

        //test set months
        assertSetMonth(1);
        assertSetMonth(2);
        assertSetMonth(4);
        assertSetMonth(7);
        assertSetMonth(11);
        assertSetMonth(12);

        //test set days to month
        assertSetDay(1, 1);
        assertSetDay(2, 1);
        assertSetDay(15, 1);
        assertSetDay(30, 1);
        assertSetDay(31, 1);

        assertSetDay(1, 2); //checks month boundary value
        assertSetDay(2, 2);
        assertSetDay(12, 2);
        assertSetDay(27, 2);
        assertSetDay(28, 2);

        assertSetDay(30, 7);
        assertSetDay(31, 7);
        assertSetDay(1, 8); //checks month boundary value
        assertSetDay(2, 8);
        assertSetDay(2, 8);

        assertSetDay(30, 11); //checks month boundary value
        assertSetDay(1, 12);
        assertSetDay(2, 12);
        assertSetDay(30, 12);
        assertSetDay(31, 12);

        //set random day of month
        Month randomMonth = Month.values()[r.nextInt(12)];
        int randomDay = r.nextInt(randomMonth.getDays()) + 1;

        assertSetDay(randomDay, randomMonth.ordinal() + 1);

    }

    @Test
    public void testMonthEnum() {
        //test month index compare to constant
        assertEquals(Month.values()[0], Month.JANUARY);
        assertEquals(Month.values()[1], Month.FEBRUARY);
        assertEquals(Month.values()[2], Month.MARCH);
        assertEquals(Month.values()[3], Month.APRIL);
        assertEquals(Month.values()[4], Month.MAY);
        assertEquals(Month.values()[5], Month.JUNE);
        assertEquals(Month.values()[6], Month.JULY);
        assertEquals(Month.values()[7], Month.AUGUST);
        assertEquals(Month.values()[8], Month.SEPTEMBER);
        assertEquals(Month.values()[9], Month.OCTOBER);
        assertEquals(Month.values()[10], Month.NOVEMBER);
        assertEquals(Month.values()[11], Month.DECEMBER);

        //test month days
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
    public void testInvalidValues() {
        //test weekday
        exceptionSetWeekday(-167);
        exceptionSetWeekday(-10);
        exceptionSetWeekday(-1);
        exceptionSetWeekday(0);
        exceptionSetWeekday(8);
        exceptionSetWeekday(9);
        exceptionSetWeekday(92);
        exceptionSetWeekday(178);

        exceptionSetWeekday(-r.nextInt(MAX_VALUE));
        exceptionSetWeekday(r.nextInt(MAX_VALUE - 7) + 8);

        //test month
        exceptionSetMonth(-160);
        exceptionSetMonth(-1);
        exceptionSetMonth(0);
        exceptionSetMonth(13);
        exceptionSetMonth(14);
        exceptionSetMonth(140);

        exceptionSetMonth(r.nextInt(MAX_VALUE - 12) + 13);
        exceptionSetMonth(-r.nextInt(MAX_VALUE));

        //test day of month
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

    private void assertSetDay(int day, int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);

        assertEquals(month, task.getMonth());
        assertEquals(0, task.getWeekdayOfNY());
        assertEquals(day, task.getDay());
    }

    private void assertSetMonth(int month) {
        Task5 task = new Task5();
        task.setMonth(month);

        assertEquals(month, task.getMonth());
        assertEquals(0, task.getWeekdayOfNY());
        assertEquals(0, task.getDay());
    }

    private void assertSetWeekdayOfNY(int weekday) {
        Task5 task = new Task5();
        task.setWeekdayOfNY(weekday);

        assertEquals(0, task.getMonth());
        assertEquals(weekday, task.getWeekdayOfNY());
        assertEquals(0, task.getDay());
    }

    private void exceptionSetWeekday(int weekday) {
        Task5 task = new Task5();
        task.setWeekdayOfNY(weekday);
        try {
            task.calculateWeekday();
            fail(MSG);
        } catch (IllegalArgumentException e) { /*expected*/ }
    }

    private void exceptionSetMonth(int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        try {
            task.calculateWeekday();
            fail(MSG);
        } catch (IllegalArgumentException e) {/*expected*/}
    }

    private void exceptionSetDay(int day, int month) {
        Task5 task = new Task5();
        task.setMonth(month);
        task.setDayOfMonth(day);
        try {
            task.calculateWeekday();
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