package corejava.chapter1.lab16;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab16 {
    public static void main(String[] args) {
        //ArrayList
        System.out.print("Enter string numbers:");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.length() > 0) {
            List<Integer> list = Arrays.stream(str.trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(average(list));
        }
    }

    public static double average(int... arr) {
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        return (double) sum / arr.length;
    }

    public static double average(List<Integer> arr) {
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        return (double) sum / arr.size();
    }
}

