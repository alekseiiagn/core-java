package corejava.chapter1.lab6;

import java.math.BigInteger;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        System.out.print("Enter int n:");
        int number = readNumberFromTerminal();
        System.out.println("n! = " + factorial(number).toString());
    }

    public static int readNumberFromTerminal() {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            return in.nextInt();
        } else {
            throw new RuntimeException("It's not number!");
        }
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }
}
