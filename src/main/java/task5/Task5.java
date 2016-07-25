package task5;

import static task5.Task5.Weekday.SUNDAY;

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
    private static final String MSG = "Day of month musts be between 1 and ";
    private int allDays; // accumulate all days before input date
    private Weekday weekdayOfNY; //weekday of new year
    private Month month; //input month

    private Weekday resultWeekday; //return value

    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        public int index() {
            return this.ordinal() + 1;
        }

        public static Weekday valueOf(int idx) {
            for (Weekday w : values()) {
                if (w.ordinal() == idx - 1) {
                    return w;
                }
            }
            return null;
        }
    }

    enum Month {
        JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30),
        MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30),
        OCTOBER(31), NOVEMBER(30), DECEMBER(31);

        private int days;

        Month(int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }

        public static Month valueOf(int idx) {
            for (Month m : values()) {
                if (m.ordinal() == idx - 1) {
                    return m;
                }
            }
            return null;
        }
    }

    public int getResultWeekday() {
        return resultWeekday.ordinal() + 1;
    }

    /**
     * Sets day of month and validate
     *
     * @param day input day of month
     * @throws IllegalArgumentException in cause if day of the month incorrect
     */
    public void setDayOfMonth(int day) {
        if (month == null) {
            throw new IllegalArgumentException("Please set month first using setMonth()");
        }

        if (day < 1 || day > month.getDays()) {
            throw new IllegalArgumentException(MSG + month.getDays());
        }

        allDays += day - 1; // add all days before input day (e.g. jan 15 , alldays = 14)
    }

    /**
     * Sets month and validate
     *
     * @param monthIndex input month of year
     * @throws IllegalArgumentException in cause month < 1 or month > 12
     */
    public void setMonth(int monthIndex) {
        month = Month.valueOf(monthIndex);
        if (month == null) {
            throw new IllegalArgumentException("Month should be between 1 and 12");
        }
    }

    /**
     * Sets weekday of new year and validate
     *
     * @param weekdayIndex input weekday of new year
     * @throws IllegalArgumentException in case weekday > 7 or weekday < 1
     */
    public void setWeekdayOfNY(int weekdayIndex) {
        weekdayOfNY = Weekday.valueOf(weekdayIndex);
        if (weekdayOfNY == null) {
            throw new IllegalArgumentException("Weekday should be between 1 and 7");
        }
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

    public void calculateWeekday() {
        calculateDays();
        //(allDays + weekdayOfNY.index()) add days before weekdayOfNY (from Friday to Monday = 5) and suggest year starts from monday
        if ((allDays + weekdayOfNY.index()) % SUNDAY.index() == 0) { //if get 0 therefore it's Sunday (if year starts from Monday than 7 January is Sunday)
            resultWeekday = SUNDAY;
        } else {
            resultWeekday = Weekday.valueOf((allDays + weekdayOfNY.index()) % SUNDAY.index());
        }
    }
}
