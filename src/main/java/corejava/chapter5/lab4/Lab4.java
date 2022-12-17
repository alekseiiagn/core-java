package corejava.chapter5.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4 {
    private static final int ERROR = 1;
    private static final int GOOD = 0;
    private static double result = 0;
    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA = "src/main/resources/chapter5/lab1/uncorrectedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile1(FILE_PATH_TO_CORRECTED_DATA);
    }

    public static void printSumOfValuesFromFile1(String filename) {
        if (sumOfValuesFromFile(filename) == ERROR) {
            System.out.println("Произошла ошибка");
        } else {
            System.out.println("Ответ: " + result);
        }
    }

    public static double sumOfValuesFromFile(String filename) {
        List<Double> numbers = new ArrayList<>();
        if (readValuesFromFile(filename, numbers) == ERROR) {
            return ERROR;
        }
        return calculateSumOfNumbers(numbers);
    }

    public static int readValuesFromFile(String filename, List<Double> numbers) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return readValues(scanner, numbers);
        } catch (FileNotFoundException | NumberFormatException | IllegalStateException e) {
            return ERROR;
        }
    }

    private static int readValues(Scanner scanner, List<Double> numbers) {
        while (scanner.hasNext()) {
            numbers.add(Double.parseDouble(scanner.next()));
        }
        return GOOD;
    }

    private static int calculateSumOfNumbers(List<Double> numbers) {
        for (double number : numbers) {
            result += number;
            if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
                return ERROR;
            }
        }
        return GOOD;
    }
}