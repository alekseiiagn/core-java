package corejava.chapter5.lab1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab1 {

    public static String FILE_PATH = "src/main/resources/chapter5/lab1/correctedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile(FILE_PATH);
    }

    //task1
    public static List<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException, IllegalStateException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Double> result = new ArrayList<>();
            while (scanner.hasNext()) {
                result.add(Double.parseDouble(scanner.next()));
            }
            return result;
        }
    }

    //task2
    //TODO не пон, но пускай будет так
    public static double sumOfValues(String filename) throws FileNotFoundException, IllegalStateException, NumberFormatException {
        double sum = 0;
        List<Double> numbers = Lab1.readValues(filename);
        for (double number :
                numbers) {
            sum += number;
        }
        return sum;
    }

    //task3
    public static void printSumOfValuesFromFile(String filename) {
        try {
            System.out.println(sumOfValues(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("-------> Error opening or reading from a file!");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("-------> Some of the data in the file are not floating-point numbers!");
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.err.println("-------> File closing error!");
        }
    }
}
