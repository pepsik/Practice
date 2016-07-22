//package task5;
//
//import static task5.Task5.Month.*;
//
///**
// * The {@code Task4} class represents a simple calendar. It calculates weekday of common year using input values: month, day, weekdayOfNewYear.
// * E.g. input values:
// * <blockquote><pre>
// * month = 2
// * day = 28
// * weekdayOfNewYear = 5
// * </pre></blockquote>
// * <p>and result will be</p>
// * <blockquote><pre>
// * weekday = 7
// * </pre></blockquote>
// */
//public class Task5 {
//    private static final String MSG = "Day of month musts be between 1 and ";
//    private int allDays; // accumulate all days before input date
//    private int weekdayOfNY; //weekday of new year
//    private int curMonth; //input month
//    private int resultWeekday; //return value
//
//    enum Weekday {
//        MONDAY, THUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
//
//        Weekday valueOf(int idx){
//            for(Weekday w : values()){
//                if (w.ordinal() == idx){
//                    return w;
//                }
//            }
//
//            JANUARY.ordinal();
//
//            return null;
//        }
//    }
//
//    enum Month {
//        JANUARY, FEBRUARY, MARCH, APRIL,
//        MAY, JUNE, JULY, AUGUST, SEPTEMBER,
//        OCTOBER, NOVEMBER, DECEMBER;
//
//        public boolean isGreater(Month month) {
//            return this.ordinal() > month.ordinal();
//        }
//
//        public boolean isLower(Month month) {
//            return this.ordinal() < month.ordinal();
//        }
//
//        public boolean isEquals(Month month) {
//            return this.ordinal() == month.ordinal();
//        }
//
//        public boolean isEven() {
//            return this.ordinal() % 2 == 0;
//        }
//
//        public static boolean isExist(int index) {
//            return index >= 1 && index <= 12;
//        }
//    }
//
//    public int getResultWeekday() {
//        return resultWeekday;
//    }
//
//    /**
//     * Sets day of month and validate
//     *
//     * @param day input day of month
//     * @throws IllegalArgumentException in cause if day of the month incorrect
//     */
//    public void setDayOfMonth(int day) {
//        Month month = Month.values()[curMonth];
//
//        if (curMonth == 0) {
//            throw new IllegalArgumentException("Please set month first using setMonth()");
//        }
//
//        if (day < 1) {
//            throw new IllegalArgumentException("Expected Day of month greater than 1, got " + day);
//        }
//
//        if (month.isEquals(FEBRUARY) && day > 28) {
//            throw new IllegalArgumentException(MSG + 28);
//        } else if (month.isEven() && month.isLower(AUGUST) || month.isGreater(AUGUST) && !month.isEven()) { //TOdo compare to
//            if (day > 30) {
//                throw new IllegalArgumentException(MSG + 30);
//            }
//        } else if (day > 31) {
//            throw new IllegalArgumentException(MSG + 31);
//        }
//
//        allDays += day - 1; // add all days before input day
//    }
//
//    /**
//     * Sets month and validate
//     *
//     * @param month input month of year
//     * @throws IllegalArgumentException in cause month < 1 or month > 12
//     */
//    public void setMonth(int month) {
//        if (Month.isExist(month)) {
//            throw new IllegalArgumentException("Month should be between 1 and 12");
//        }
//        curMonth = month;
//    }
//
//    /**
//     * Sets weekday of new year and validate
//     *
//     * @param indexWeekday input weekday of new year
//     * @throws IllegalArgumentException in case weekday > 7 or weekday < 1
//     */
//    public void setWeekdayOfNY(int indexWeekday) {
//        if (Weekday.isExist(indexWeekday)) {
//            throw new IllegalArgumentException("Weekday should be between 1 and 7");
//        }
//        weekdayOfNY = indexWeekday;
//    }
//
//    /**
//     * Calculate and sum all days before input day
//     */
//    private void calculateDays() {
//        for (int i = 1; i < curMonth; i++) {
//            Month curr = Month.values()[i];
//            if ((curr == FEBRUARY && curr.FEBRUARY.index() && i != 2) || (i % 2 != 0 && i >= 7)) {//todo comment, better rewrite
//                allDays += 30; //todo magic constant?
//            } else if (i == FEBRUARY.ordinal()) {
//                allDays += 28;
//            } else {
//                allDays += 31;
//            }
//        }
//    }//todo enum, both for day and month
//
//    public void calculateWeekday() {
//        calculateDays();
//        if ((allDays + weekdayOfNY) % 7 == 0) {
//            resultWeekday = 7;
//        } else {
//            resultWeekday = (allDays + weekdayOfNY) % 7;
//        }
//    }
//}
