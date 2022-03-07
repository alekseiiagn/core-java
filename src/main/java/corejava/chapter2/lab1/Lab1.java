package corejava.chapter2.lab1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Lab1 {

    public static void main(String[] argv) {
        showNamesOfWeekDays();
        printNumbersOfMonth(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1));
    }

    public static void printNumbersOfMonth(LocalDate date) {
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        for (int i = 1; i < value + 1; i++)
            System.out.print("    ");

        while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    public static void showNamesOfWeekDays() {
        for (int i = 0; i < 7; i++) {
            System.out.printf("%4s", DayOfWeek.of((i + 6) % 7 + 1).toString().substring(0, 3));
        }
        System.out.println();
    }
}
