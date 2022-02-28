package corejava.chapter1.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {
        List<Integer> arr = readArrayFromTerminal();
        System.out.println("Result:" +
                "\nmaxIf = " + maxIf(arr) +
                "\nmaxMath = " + maxMath(arr));
    }

    public static int maxIf(List<Integer> arr) {
        int maxIf = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (arr.get(i) > maxIf) maxIf = arr.get(i);
        }
        return maxIf;
    }

    public static int maxMath(List<Integer> arr) {
        int maxMath = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            maxMath = Math.max(maxMath, arr.get(i));
        }
        return maxMath;
    }

    public static List<Integer> readArrayFromTerminal() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 3 int numbers:");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (in.hasNextInt()) {
                arr.add(in.nextInt());
            } else {
                throw new RuntimeException("It's not number!");
            }
        }
        return arr;
    }
}
