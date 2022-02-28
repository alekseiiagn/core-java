package corejava.chapter1.lab2;

import java.util.Scanner;

import static java.lang.Math.floorMod;

public class Lab2 {
    public static void main(String[] argv) {
        System.out.print("Enter value corner as int number:");
        int number = readNumberFromTerminal();
        System.out.print("Result:" +
                "\n%: " + number % 360 +
                "\nfloorMod(): " + floorMod(number, 360));
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
