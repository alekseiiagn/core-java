package corejava.chapter5.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4 {

    /**
     * ОЛО, НЕ ДЕЛАЙ СУММУ РАВНОЙ -1
     */
    public static String FILE_PATH = "src/main/resources/chapter5/lab1/correctedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile1(FILE_PATH);
    }

    public static List<Double> readValues(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Double> result = new ArrayList<>();
            while (scanner.hasNext()) {
                result.add(Double.parseDouble(scanner.next()));
            }
            return result;
        } catch (FileNotFoundException | NumberFormatException | IllegalStateException e) {
            return null;
        }
    }

    public static double sumOfValues(String filename) {
        double sum = 0;
        List<Double> numbers = Lab4.readValues(filename);
        if (numbers == null) {
            return -1;
        }
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    //task3
    public static void printSumOfValuesFromFile1(String filename) {
        double res = sumOfValues(filename);
        if (res == -1) {
            System.out.println("Произошла ошибка");
        } else {
            System.out.println("Ответ: " + res);
        }
    }
}
