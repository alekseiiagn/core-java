package corejava.chapter5.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO не пон
public class Lab4 {

    public static String FILE_PATH = "src/main/resources/chapter5/lab1/uncorrectedData.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile1(FILE_PATH);
    }

    public static List<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException, IllegalStateException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Double> result = new ArrayList<>();
            while (scanner.hasNext()) {
                result.add(Double.parseDouble(scanner.next()));
            }
            return result;
        }
    }

    public static double sumOfValues(String filename) throws FileNotFoundException, IllegalStateException, NumberFormatException {
        double sum = 0;
        List<Double> numbers = Lab4.readValues(filename);
        for (double number :
                numbers) {
            sum += number;
        }
        return sum;
    }

    //task3
    public static void printSumOfValuesFromFile1(String filename) {
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
