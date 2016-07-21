package task5;

import java.util.Scanner;

/**
 * The {@code Task4} class represents a simple calendar. It calculates weekday of common year using input values: month, day, weekdayOfNewYear.
 * E.g. input values:
 * <blockquote><pre>
 * month = 2
 * day = 28
 * weekdayOfNewYear = 5
 * </pre></blockquote>
 * <p>and result will be</p>
 * <blockquote><pre>
 * weekday = 7
 * </pre></blockquote>
 */
public class Task5 {
    private int allDays;//todo comment fields
    private int weekdayOfNY;
    private int curMonth;
    private int resultWeekday;

    private static final int JANUARY = 500;

    public int getResultWeekday() {
        return resultWeekday;
    }

    /**
     * Sets day of month and checks if it valid otherwise {@link IllegalArgumentException} will thrown
     * @param day input day of month
     */
    public void setDayOfMonth(int day) {
        if (curMonth == 0) {
            throw new IllegalArgumentException("Please set month first using setMonth()");
        }
        if (day < 1) {
            throw new IllegalArgumentException("Expected Day of month greater than 1, got "+day);
        }
        if ((curMonth % 2 == 0 && curMonth < 8 && curMonth != 2) || (curMonth % 2 != 0 && curMonth > 8)) {
            if (day > 30) {
                throw new IllegalArgumentException("Day of month " + curMonth + " musts be between 1 and 30");
            }
        } else if (curMonth == 2) {
            if (day > 28) {
                throw new IllegalArgumentException("Day of month " + curMonth + " musts be between 1 and 28");
            }
        } else {
            if (day > 31) {
                throw new IllegalArgumentException("Day of month " + curMonth + " musts be between 1 and 31");
            }
        }
        allDays += day - 1;
    }

    /**
     * Sets month and checks if it valid otherwise {@link IllegalArgumentException} will thrown
     * @param month input month of year
     */
    public void setMonth(int month) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Month should be between 1 and 12");
        }
        curMonth = month;
    }

    /**
     * Sets weekday of new year and checks if it valid otherwise {@link IllegalArgumentException} will thrown
     * @param weekday input weekday of new year
     */
    public void setWeekdayOfNY(int weekday) {
        if (weekday > 7 || weekday < 1) {
            throw new IllegalArgumentException("Weekday should be between 1 and 7");
        }
        weekdayOfNY = weekday;
    }

    /**
     * Calculate and sum all days before input day
     */
    private void calculateDays() {
        for (int i = 1; i < curMonth; i++) {
            if ((i % 2 == 0 && i < 8 && i != 2) || (i % 2 != 0 && i > 8)) {//todo comment, better rewrite
                allDays += 30;//todo magic constant?
            } else if (i == 2) {
                allDays += 28;
            } else {
                allDays += 31;
            }
        }
    }//todo enum, both for day and month

    public void calculateWeekday() {
        calculateDays();
        if ((allDays + weekdayOfNY) % 7 == 0) {
            resultWeekday = 7;
        } else {

            resultWeekday = (allDays + weekdayOfNY) % 7;
        }
    }

    public static void main(String[] args) {
        Task5 task = new Task5();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month - ");
        task.setMonth(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter day of the month - ");
        task.setDayOfMonth(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter weekdayOfNY - ");
        task.setWeekdayOfNY(Integer.parseInt(scanner.nextLine()));
        task.calculateWeekday();
        System.out.print("Result - " + task.getResultWeekday());
    }
}
