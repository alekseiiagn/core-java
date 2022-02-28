package corejava.chapter1.lab15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter int number:");
        if (in.hasNextInt()) {
            List<List<Integer>> arr = createArray(in.nextInt());
            addInfo(arr);
            print(arr);
        } else {
            throw new RuntimeException("It's not int number!");
        }
    }

    private static List<List<Integer>> createArray(int number) {
        List<List<Integer>> arr = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            arr.add(new ArrayList<>());
        }
        return arr;
    }

    public static void addInfo(List<List<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j <= i; j++) {
                arr.get(i).add(getInt(j, i));
            }
        }
    }

    public static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    public static int getInt(int k, int n) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void print(List<List<Integer>> arr) {
        for (List<Integer> list : arr) {
            System.out.println(list);
        }
    }
}
