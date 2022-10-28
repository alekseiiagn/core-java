package corejava.chapter5.additional.withExceptions;

import corejava.chapter5.additional.withoutExceptions.CantSumOfValuesFromFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA = "src/main/resources/chapter5/lab1/uncorrectedData1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        sumOfValuesFromFile(FILE_PATH_TO_UNCORRECTED_DATA);
    }

    private static double sumOfValuesFromFile(String filename) {
        try {
            List<Double> numbers = readValuesFromFile(filename);
            return calculateSumOfNumbers(numbers);
        } catch (FileNotFoundException e) {
            throw new CantSumOfValuesFromFileException("File not found by filename: " + filename, e);
        } catch (NumberFormatException e) {
            throw new CantSumOfValuesFromFileException("File " + filename + " have not double values: ", e);
        } catch (RuntimeException e) {
            throw new CantSumOfValuesFromFileException("Technical exception: ", e);
        }
    }

    private static List<Double> readValuesFromFile(String filename) throws FileNotFoundException, NumberFormatException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return readValues(scanner);
        }
    }

    private static List<Double> readValues(Scanner scanner) {
        List<Double> result = new ArrayList<>();
        while (scanner.hasNext()) {
            result.add(Double.parseDouble(scanner.next()));
        }
        return result;
    }

    private static double calculateSumOfNumbers(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
}
