package task5;

import org.junit.Before;
import org.junit.Test;

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

    @Test(expected = IllegalArgumentException.class)
    public void invalidWeekdayLessOne() {
        task.setWeekdayOfNewYear(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidWeekdayMoreSeven() {
        task.setWeekdayOfNewYear(8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMonthLessOne() {
        task.setMonth(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMonthMoreTwelve() {
        task.setMonth(13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDayOfMonth() {
        task.setMonth(3);
        task.setDayOfMonth(30);
    }

}