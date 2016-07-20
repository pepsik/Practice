package task5;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task5Test {
    private Task5 task;
    public static Class<? extends Exception> expectedException;

    @Before
    public void setUp() {
        task = new Task5();
    }

    // --------------- OLD
    private void setDayOfMonth(int day, int month, String failMessage) {
        task.setMonth(month);
        try {
            task.setDayOfMonth(day);
            fail(failMessage);
        } catch (IllegalArgumentException e) {/*nothing*/ }
    }
    //-----------------

    private class TestCube {
        private Integer day;
        private Integer month;
        private Integer weekdayNY;
        private Task5 task = new Task5();

        public TestCube day(int day) {
            this.day = day;
            return this;
        }

        public TestCube month(int month) {
            this.month = month;
            return this;
        }

        public TestCube weekdayOfNY(int weekday) {
            this.weekdayNY = weekday;
            return this;
        }

        public void testDay(int day) {
            initValues();
            if (isExpectedException())
                try {
                    task.setDayOfMonth(day);
                    fail(failMessage("day", day));
                } catch (Exception e) {
                    assertThat(e, instanceOf(expectedException));
                }
            else
                task.setDayOfMonth(day);
        }

        public void testMonth(int month) {
            if (isExpectedException())
                try {
                    task.setMonth(month);
                    fail(failMessage("month", month));
                } catch (Exception e) {
                    assertThat(e, instanceOf(expectedException));
                }
            else
                task.setMonth(month);
        }

        public void testWeekdayOfNY(int weekdayOfNY) {
            if (isExpectedException())
                try {
                    task.setWeekdayOfNewYear(weekdayOfNY);
                    fail(failMessage("weekdayOfNY", weekdayOfNY));
                } catch (Exception e) {
                    assertThat(e, instanceOf(expectedException));
                }
            else
                task.setWeekdayOfNewYear(weekdayOfNY);
        }

        public void testExpectedWeekday(int expectWeekday) {
            initValues();
            task.calculateWeekday();
            if (expectWeekday != task.getCurrentWeekday())
                throw new RuntimeException("weekday WAS:" + task.getCurrentWeekday() + " but EXPECTED:" + expectWeekday);
        }

        private String failMessage(String str, int value) {
            return "Expected exception of \"" + expectedException + "\" !NOT THROWN!" +
                    "\n Checked data: \n " + str + " = " + value;
        }

        private boolean isExpectedException() {
            return expectedException != null;
        }

        private void initValues() {
            if (weekdayNY != null)
                task.setWeekdayOfNewYear(weekdayNY);
            if (month != null)
                task.setMonth(month);
            if (day != null)
                task.setDayOfMonth(day);
        }
    }

    public TestCube build() {
        return new TestCube();
    }

    @Test
    public void invalidWeekday() {
        expectedException = IllegalArgumentException.class;
        build().testWeekdayOfNY(0);
        build().testWeekdayOfNY(8);
        build().testWeekdayOfNY(new Random().nextInt(Integer.MAX_VALUE) * -1);
        build().testWeekdayOfNY(new Random().nextInt(Integer.MAX_VALUE - 7) + 9);
    }

    @Test
    public void invalidMonth() {
        expectedException = IllegalArgumentException.class;
        build().testMonth(0);
        build().testMonth(13);
        build().testMonth(new Random().nextInt(Integer.MAX_VALUE - 12) + 14);
        build().testMonth(new Random().nextInt(Integer.MAX_VALUE) * -1);
    }

    @Test
    public void invalidDayOfMonth() {
        setDayOfMonth(32, 3, "3th month does not have 32 days");

        expectedException = IllegalArgumentException.class;
        build().testDay(20);
        build().month(3).testDay(32);
        build().month(2).testDay(29);
        build().month(7).testDay(32);
        build().month(8).testDay(32);
        build().month(11).testDay(31);
        build().month(12).testDay(32);
        build().month(11).testDay(new Random().nextInt(Integer.MAX_VALUE) * -1);
    }

    @Test
    public void validMonth() {
        expectedException = null;
        build().testMonth(1);
        build().testMonth(12);
        build().testMonth(new Random().nextInt(12) + 1);
    }

    @Test
    public void validWeekday() {
        expectedException = null;
        build().testWeekdayOfNY(1);
        build().testWeekdayOfNY(7);
        build().testWeekdayOfNY(new Random().nextInt(7) + 1);
    }

    @Test
    public void validDayOfMonth() {
        expectedException = null;
        build().month(2).testDay(28);
        build().month(12).testDay(31);
        build().month(7).testDay(31);
        build().month(5).testDay(31);
    }

    @Test
    public void validValues() {
        build().day(17).month(7).weekdayOfNY(3).testExpectedWeekday(4);
        build().day(19).month(7).weekdayOfNY(5).testExpectedWeekday(1);
        build().day(20).month(11).weekdayOfNY(5).testExpectedWeekday(6);
        build().day(3).month(8).weekdayOfNY(5).testExpectedWeekday(2);
    }
}