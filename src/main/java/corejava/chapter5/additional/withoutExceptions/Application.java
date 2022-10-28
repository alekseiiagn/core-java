package corejava.chapter5.additional.withoutExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA = "src/main/resources/chapter5/lab1/uncorrectedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile(FILE_PATH_TO_UNCORRECTED_DATA);
    }

    public static void printSumOfValuesFromFile(String filename) {
        CustomNumber<Double> res = sumOfValuesFromFile(filename);
        if (res.getError() != null) {
            System.err.println("Ошибка: " + res.getError());
        } else {
            System.out.println("Ответ: " + res.getAnswer());
        }
    }

    public static CustomNumber<Double> sumOfValuesFromFile(String filename) {
        CustomList<Double> numbers = readValuesFromFile(filename);
        CustomError error = numbers.getError();
        if (numbers.getError() != null) {
            return new CustomNumber<>(0d, error);
        }
        double sum = calculateSumOfNumbers(numbers.getData());
        return new CustomNumber<>(sum, error);
    }

    public static CustomList<Double> readValuesFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return CustomList.of(readValues(scanner));
        } catch (FileNotFoundException e) {
            return CustomList.of(CustomError.FILE_NOT_FOUND);
        } catch (NumberFormatException e) {
            return CustomList.of(CustomError.INCORRECT_SYMBOL);
        } catch (IllegalStateException e) {
            return CustomList.of(CustomError.TECHNICAL_ERROR);
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
