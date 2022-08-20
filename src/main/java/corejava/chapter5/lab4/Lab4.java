package corejava.chapter5.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4 {

    /**
     * ОЛО, НЕ ДЕЛАЙ СУММУ РАВНОЙ -1
     */
    private static final int ERROR = -1;
    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA = "src/main/resources/chapter5/lab1/uncorrectedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile1(FILE_PATH_TO_CORRECTED_DATA);
    }

    public static List<Double> readValuesFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return readValues(scanner);
        } catch (FileNotFoundException | NumberFormatException | IllegalStateException e) {
            return null;
        }
    }

    private static List<Double> readValues(Scanner scanner) {
        List<Double> result = new ArrayList<>();
        while (scanner.hasNext()) {
            result.add(Double.parseDouble(scanner.next()));
        }
        return result;
    }

    public static double sumOfValuesFromFile(String filename) {
        List<Double> numbers = Lab4.readValuesFromFile(filename);
        if (numbers == null) {
            return ERROR;
        }
        return calculateSumOfNumbers(numbers);
    }

    private static double calculateSumOfNumbers(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void printSumOfValuesFromFile1(String filename) {
        double res = sumOfValuesFromFile(filename);
        if (res == ERROR) {
            System.out.println("Произошла ошибка");
        } else {
            System.out.println("Ответ: " + res);
        }
    }
}
