package corejava.chapter5.lab1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab1_2_3 {

    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA = "src/main/resources/chapter5/lab1/uncorrectedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile(FILE_PATH_TO_CORRECTED_DATA);
    }

    //task1
    private static List<Double> readValuesFromFile(String filename) throws FileNotFoundException, NumberFormatException, IllegalStateException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Double> result = new ArrayList<>();
            while (scanner.hasNext()) {
                result.add(Double.parseDouble(scanner.next()));
            }
            return result;
        }
    }

    //task2
    private static double sumOfValuesFromFile(String filename) throws FileNotFoundException, IllegalStateException, NumberFormatException {
        List<Double> numbers = Lab1_2_3.readValuesFromFile(filename);
        return calculateSumOfNumbers(numbers);
    }

    private static double calculateSumOfNumbers(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
            if (sum == Double.POSITIVE_INFINITY || sum == Double.NEGATIVE_INFINITY) {
                throw new RuntimeException("Sum of values > Double.MAX");
            }
        }
        return sum;
    }

    //task3
    private static void printSumOfValuesFromFile(String filename) {
        try {
            System.out.println(sumOfValuesFromFile(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e + " -------> Error opening or reading from a file!");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println(e + " -------> Some of the data in the file are not floating-point numbers!");
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.err.println(e + " -------> File closing error!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println(e + " -------> Sum of values in file > Double.MAX!");
        }
    }
}