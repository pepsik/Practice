package task5;

import java.util.Scanner;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task5 {
    private int allDays;
    private int weekdayOfNewYear;
    private int currentDay;
    private int currentMonth;
    private int currentWeekday;

    public int getCurrentWeekday() {
        return currentWeekday;
    }

    public void setDayOfMonth(int day) {
        currentDay = day;
        if (currentMonth == 0)
            throw new IllegalArgumentException("Must set month first!");
        if (currentDay < 1)
            throw new IllegalArgumentException("Day of month " + currentMonth + " must be more than 1");
        if ((currentMonth % 2 == 0 && currentMonth < 8 && currentMonth != 2) || (currentMonth % 2 != 0 && currentMonth > 8)) {
            if (currentDay > 30)
                throw new IllegalArgumentException("Day of month " + currentMonth + " musts be between 1 and 30");
        } else if (currentMonth == 2) {
            if (currentDay > 28)
                throw new IllegalArgumentException("Day of month " + currentMonth + " musts be between 1 and 28");
        } else {
            if (currentDay > 31)
                throw new IllegalArgumentException("Day of month " + currentMonth + " musts be between 1 and 31");
        }
        allDays += currentDay - 1;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1)
            throw new IllegalArgumentException("Month should be between 1 and 12");
        currentMonth = month;
    }

    public void setWeekdayOfNewYear(int weekday) {
        if (weekday > 7 || weekday < 1)
            throw new IllegalArgumentException("Weekday should be between 1 and 7");
        weekdayOfNewYear = weekday;
    }

    private void calculateDays() {
        for (int i = 1; i < currentMonth; i++) {
            if ((i % 2 == 0 && i < 8 && i != 2) || (i % 2 != 0 && i > 8)) {
                allDays += 30;
            } else if (i == 2) {
                allDays += 28;
            } else {
                allDays += 31;
            }
        }
    }

    public void calculateWeekday() {
        calculateDays();
        if ((allDays + weekdayOfNewYear) % 7 == 0)
            currentWeekday = 7;
        else
            currentWeekday = (allDays + weekdayOfNewYear) % 7;
    }

    @Override
    public String toString() {
        return "Task5{" +
                "allDays=" + allDays +
                ", weekdayOfNewYear=" + weekdayOfNewYear +
                ", currentDay=" + currentDay +
                ", currentMonth=" + currentMonth +
                ", currentWeekday=" + currentWeekday +
                '}';
    }

    public static void main(String[] args) {
        Task5 task = new Task5();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month - ");
        task.setMonth(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter day of the month - ");
        task.setDayOfMonth(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter weekdayOfNewYear - ");
        task.setWeekdayOfNewYear(Integer.parseInt(scanner.nextLine()));
        task.calculateWeekday();
        System.out.print("Result - " + task.getCurrentWeekday());
    }
}
