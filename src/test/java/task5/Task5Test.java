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

    private void setDayOfMonth(int day, int month, String failMessage) {
        task.setMonth(month);
        try {
            task.setDayOfMonth(day);
            fail(failMessage);
        } catch (IllegalArgumentException e) {/*nothing*/ }
    }

    private enum TestType {
        SUCCESS, FAIL
    }

    private class TestCube {
        private Task5 task = new Task5();
        private Integer day;
        private Integer month;
        private Integer weekdayNY;
        private String failMessage;
        private int expectWeekday;
        private TestType testType = TestType.FAIL;
        public Class<? extends Throwable> exceptionType = IllegalArgumentException.class;

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

        public TestCube expect(Class<? extends Exception> exception) {
            exceptionType = exception;
            testType = TestType.FAIL;
            return this;
        }

        public TestCube expect(TestType type) {
            if (type != TestType.SUCCESS)
                throw new RuntimeException("TestCube not configured properly (EXPECT)");
            return this;
        }

        public TestCube expect(int number) {
            testType = TestType.SUCCESS;
            expectWeekday = number;
            return this;
        }

        public TestCube unexpected(String message) {
            failMessage = message;
            return this;
        }

        private void initValues() {
            if (weekdayNY != null)
                task.setWeekdayOfNewYear(weekdayNY);
            if (month != null)
                task.setMonth(month);
            if (day != null)
                task.setDayOfMonth(day);
            task.calculateWeekday();
        }

        private void failureTest() {

        }

        private void successTest() {

        }

        public void start() {
            try {
                initValues();
                if (expectWeekday != 0 && expectWeekday != task.getCurrentWeekday())
                    throw new RuntimeException("weekday WAS:" + task.getCurrentWeekday() + " but EXPECTED:" + expectWeekday);

                if (!failMessage.equals("throw"))
                    fail(failMessage);
            } catch (Exception e) {
                if (exceptionType != null)
                    assertThat(e, instanceOf(exceptionType));
                else
                    throw e;
            }
        }
    }

    public TestCube test() {

        return new TestCube();
    }

    @Test
    public void invalidWeekday() {
        String msg = "Weekday can't be ";
        test().weekdayOfNY(0).unexpected(msg + 0).start();
        test().weekdayOfNY(8).unexpected(msg + 8).start();
        test().weekdayOfNY(new Random().nextInt(Integer.MAX_VALUE) * -1).unexpected(msg + "negative").start();
        test().weekdayOfNY(new Random().nextInt(Integer.MAX_VALUE - 7) + 9).unexpected(msg + "more than 7").start();
    }

    @Test
    public void invalidMonth() {
        String msg = "Month can't be ";
        test().month(0).unexpected(msg + 0).start();
        test().month(13).unexpected(msg + 13).start();
        test().month(new Random().nextInt(Integer.MAX_VALUE - 12) + 14).unexpected(msg + "more than 12").start();
        test().month(new Random().nextInt(Integer.MAX_VALUE) * -1).unexpected(msg + "negative").start();
    }

    @Test
    public void invalidDayOfMonth() {
        setDayOfMonth(32, 3, "3th month does not have 32 days");
        String msg = "th month does not have ";
        test().day(20).unexpected("Month should set first").start();
        test().month(3).day(32).unexpected(3 + msg + 32).start();
        test().month(2).day(29).unexpected(2 + msg + 29).start();
        test().month(7).day(32).unexpected(7 + msg + 32).start();
        test().month(8).day(32).unexpected(8 + msg + 32).start();
        test().month(11).day(31).unexpected(11 + msg + 31).start();
        test().month(12).day(32).unexpected(12 + msg + 32).start();
        test().month(11).day(new Random().nextInt(Integer.MAX_VALUE) * -1).unexpected("Month can't have negative days");
    }

    @Test
    public void validMonth() {
        test().month(1).expect(TestType.SUCCESS).unexpected("throw").start();
        test().month(12).expect(TestType.SUCCESS).unexpected("throw").start();
        test().month(new Random().nextInt(12) + 1).expect(TestType.SUCCESS).unexpected("throw").start();
    }

    @Test
    public void validWeekday() {
        test().weekdayOfNY(1).expect(TestType.SUCCESS).unexpected("throw").start();
        test().weekdayOfNY(7).expect(TestType.SUCCESS).unexpected("throw").start();
        test().weekdayOfNY(new Random().nextInt(7) + 1).expect(TestType.SUCCESS).unexpected("throw").start();
    }

    @Test
    public void validDayOfMonth() {
        test().day(28).month(2).expect(TestType.SUCCESS).unexpected("throw").start();
        test().day(31).month(12).expect(TestType.SUCCESS).unexpected("throw").start();
        test().day(31).month(7).expect(TestType.SUCCESS).unexpected("throw").start();
        test().day(31).month(5).expect(TestType.SUCCESS).unexpected("throw").start();
    }

    @Test
    public void validValues() {
        test().day(17).month(7).weekdayOfNY(3).expect(4).unexpected("throw").start();
        test().day(19).month(7).weekdayOfNY(5).expect(1).unexpected("throw").start();
        test().day(20).month(11).weekdayOfNY(5).expect(6).unexpected("throw").start();
        test().day(3).month(8).weekdayOfNY(5).expect(2).unexpected("throw").start();
    }
}