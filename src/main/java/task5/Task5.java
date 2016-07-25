package task5;

import static task5.Weekday.SUNDAY;

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

    /**
     * Accumulate all days before input date
     */
    private int allDays;

    /**
     * Weekday of new year
     */
    private Weekday weekdayOfNY;

    /**
     * Month of year
     */
    private Month month;

    /**
     * Result weekday
     */
    private Weekday result;

    public int getResultWeekday() {
        return result.index();
    }

    public int getAllDays() {
        return allDays;
    }

    public Month getMonth() {
        return month;
    }

    /**
     * Sets day of month and validate
     *
     * @param day input day of month
     * @throws IllegalArgumentException in cause if day of the month incorrect
     */
    public void setDayOfMonth(int day) {
        if (month == null) {
            throw new IllegalArgumentException("Please set month first!");
        }

        if (day < 1 || day > month.getDays()) {
            throw new IllegalArgumentException("Day of month musts be between 1 and " + month.getDays());
        }

        allDays += day - 1; // add all days before input day (e.g. jan 15 , alldays = 14)
    }

    /**
     * Sets month and validate
     *
     * @param monthIndex input month of year
     */
    public void setMonth(int monthIndex) {
        month = Month.valueOf(monthIndex);
    }

    /**
     * Sets weekday of new year and validate
     *
     * @param weekdayIndex input weekday of new year
     */
    public void setWeekdayOfNY(int weekdayIndex) {
        weekdayOfNY = Weekday.valueOf(weekdayIndex);
    }

    public Weekday getWeekdayOfNY() {
        return weekdayOfNY;
    }

    /**
     * Calculate and sum all days before input day
     */
    private void calculateDays() {
        for (Month m : Month.values()) {
            if (m.equals(month)) {
                break;
            }
            allDays += m.getDays();
        }
    }

    /**
     * Calculates weekday
     */
    public void calculateWeekday() {
        calculateDays();
        int days = allDays + weekdayOfNY.index(); // suppose NY starts with Monday then add weekday of NY index to all days
        int targetWeekday = days % SUNDAY.index();

        if (targetWeekday == 0) { //if get 0 therefore it's Sunday (e.g. if 1 Jan is MONDAY than 7 Jan is SUNDAY, but we have 7%7=0)
            result = SUNDAY;
        } else {
            result = Weekday.valueOf(targetWeekday);
        }
    }
}

