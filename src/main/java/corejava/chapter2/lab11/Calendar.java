package corejava.chapter2.lab11;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.of;
import static java.time.LocalDate.of;
import static java.lang.System.out;

public class Calendar {

    public static void show() {
        LocalDate date = of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1);
        showNamesOfWeekDays();
        printDaysOfMonth(date);
    }

    private static void printDaysOfMonth(LocalDate date) {
        int value = date.getDayOfWeek().getValue();
        for (int i = 1; i < value + 1; i++)
            out.print("    ");

        while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (date.getDayOfWeek() == SUNDAY) {
                out.println();
            }
            out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    private static void showNamesOfWeekDays() {
        for (int i = 0; i < 7; i++) {
            out.printf("%4s", of((i + 6) % 7 + 1).toString().substring(0, 3));
        }
        out.println();
    }
}
