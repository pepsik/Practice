package task5;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task5Test {
    private Task5 task;

    @Before
    public void setUp() {
        task = new Task5();
    }

    @Test
    public void invalidWeekday() {
        try {
            task.setWeekdayOfNewYear(0);
            fail("Weekday can't be 0");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setWeekdayOfNewYear(8);
            fail("Weekday can't be 8");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setWeekdayOfNewYear(new Random().nextInt(Integer.MAX_VALUE) * -1);
            fail("Weekday can't be negative");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setWeekdayOfNewYear(new Random().nextInt(Integer.MAX_VALUE - 7) + 9);
            fail("Weekday can't be more than 7");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
    }

    @Test
    public void invalidMonth() {
        try {
            task.setMonth(0);
            fail("Month can't be zero");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(13);
            fail("Month can't be 13");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(new Random().nextInt(Integer.MAX_VALUE - 12) + 14);
            fail("Month can't be more than 12");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(new Random().nextInt(Integer.MAX_VALUE) * -1);
            fail("Month can't be negative");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
    }

    @Test
    public void invalidDayOfMonth() {
        try {
            task.setDayOfMonth(20);
            task.setMonth(11);
            fail("Month should set first");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(3);
            task.setDayOfMonth(32);
            fail("3th month does not have 32 days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(2);
            task.setDayOfMonth(29);
            fail("2nd month does not have 29 days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(7);
            task.setDayOfMonth(32);
            fail("7th month does not have 32 days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(8);
            task.setDayOfMonth(32);
            fail("8th month does not have 32 days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(11);
            task.setDayOfMonth(31);
            fail("11th month does not have 31 days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(12);
            task.setDayOfMonth(32);
            fail("12th month does not have 32 days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
        try {
            task.setMonth(11);
            task.setDayOfMonth(new Random().nextInt(Integer.MAX_VALUE) * -1);
            fail("Month can't have negative days");
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
    }

    @Test
    public void validMonth() {
        task.setMonth(1);
        task.setMonth(12);
        task.setMonth(new Random().nextInt(12) + 1);
    }

    @Test
    public void validWeekday() {
        task.setWeekdayOfNewYear(1);
        task.setWeekdayOfNewYear(7);
        task.setWeekdayOfNewYear(new Random().nextInt(7) + 1);
    }

    @Test
    public void validDayOfMonth() {
        task.setMonth(2);
        task.setDayOfMonth(28);
        task.setMonth(12);
        task.setDayOfMonth(31);
        task.setMonth(7);
        task.setDayOfMonth(31);
        task.setMonth(5);
        task.setDayOfMonth(31);
    }
}