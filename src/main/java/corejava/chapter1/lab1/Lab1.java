package corejava.chapter1.lab1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        System.out.print("Enter int number:");
        int number = readNumberFromTerminal();
        System.out.println("Result:" +
                "\nnumber [2]: " + Integer.toString(number, 2) +
                "\nnumber [8]: " + Integer.toString(number, 8) +
                "\nnumber [16]: " + Integer.toString(number, 16) +
                "\n1/number [16]: " + Double.toHexString(1 / (double) number));
    }

    public static int readNumberFromTerminal() {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            return in.nextInt();
        } else {
            throw new RuntimeException("It's not number!");
        }
    }
}
