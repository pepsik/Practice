package task5;

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
     * Day of month
     */
    private int day;

    /**
     * Weekday of new year
     */
    private int weekdayOfNY;

    /**
     * Month of year
     */
    private int month;

    /**
     * Result weekday
     */
    private int result;

    /**
     * Sets day of month and validate. Can be set after month number.
     *
     * @param day input day of month
     * @throws IllegalArgumentException in cause if day of the month incorrect
     */
    public void setDayOfMonth(int day) {
        this.day = day;
    }

    /**
     * Sets month and validate
     *
     * @param monthIndex input month of year
     */
    public void setMonth(int monthIndex) {
        month = monthIndex;
    }

    /**
     * Sets weekday of new year and validate
     *
     * @param weekdayIndex input weekday of new year
     */
    public void setWeekdayOfNY(int weekdayIndex) {
        weekdayOfNY = weekdayIndex;
    }

    public int getResultWeekday() {
        return result;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getWeekdayOfNY() {
        return weekdayOfNY;
    }

    /**
     * Calculate and sum all days before input day
     */
    private int calculateDays() {
        checkValues();
        int allDays = 0;
        for (Month m : Month.values()) {
            if (m.ordinal() + 1 == month) {
                break;
            }
            allDays += m.getDays(); //add all month days
        }
        allDays += day - 1; //add days before target day in current month
        return allDays;
    }

    /**
     * Calculates weekday
     */
    public void calculateWeekday() {
        final int sunday = 7;

        int days = calculateDays() + weekdayOfNY; // suppose NY starts with Monday then add weekday of NY index to all days
        int targetWeekday = days % sunday;

        if (targetWeekday == 0) { //if get 0 therefore it's Sunday (e.g. if 1 Jan is MONDAY than 7 Jan is SUNDAY, but we have 7%7=0)
            result = sunday;
        } else {
            result = targetWeekday;
        }
    }

    /**
     * Validates values
     *
     * @throws IllegalArgumentException in cases (1 < month, month > 12) or (1 < day, day > month days) or (1 < weekday, weekday > 7)
     */
    private void checkValues() {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month should be between 1 and 12 but WAS:" + month);
        }

        Month month = Month.values()[this.month - 1]; // find valid enum month

        if (day < 1 || day > month.getDays()) { //checks day value
            throw new IllegalArgumentException("Day of month musts be between 1 and " + month.getDays());
        }

        if (weekdayOfNY < 1 || weekdayOfNY > 7) {
            throw new IllegalArgumentException("Weekday should be between 1 and 7 but WAS: " + weekdayOfNY);
        }
    }
}

