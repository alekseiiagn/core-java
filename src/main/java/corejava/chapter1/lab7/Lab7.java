package corejava.chapter1.lab7;

import java.util.Scanner;

public class Lab7 {
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.printf("Enter 2 numbers [0;%d]: ", 2L * MAX);

        int intNumber1 = readUnsignedIntFromTerminal();
        int intNumber2 = readUnsignedIntFromTerminal();

        System.out.println("1: " + fromUnsignedInt(intNumber1) + "\n2: " + fromUnsignedInt(intNumber2));

        System.out.println("Result:" +
                "\n+ :" + fromUnsignedInt(sumForUnsignedInt(intNumber1, intNumber2)) +
                "\n- :" + fromUnsignedInt(subForUnsignedInt(intNumber1, intNumber2)) +
                "\n* :" + fromUnsignedInt(multForUnsignedInt(intNumber1, intNumber2)) +
                "\n/ :" + fromUnsignedInt(devForUnsignedInt(intNumber1, intNumber2)) +
                "\n% :" + fromUnsignedInt(modForUnsignedInt(intNumber1, intNumber2))
        );
    }

    public static int sumForUnsignedInt(int a, int b) {
        if (a > 0 && b > 0) {
            throw new ArithmeticException("[1] sum: > " + 2L * MAX);
        }
        if (a > 0 && b < 0 || a < 0 && b > 0) {
            if (a + b > 0) {
                throw new ArithmeticException("[2] sum: > " + 2L * MAX);
            }
        }
        return a + MAX + b /*+ MAX - MAX*/;
    }

    public static int subForUnsignedInt(int a, int b) {
        if (a < b) {
            throw new ArithmeticException("sub: < 0");
        }

        return a - b - MAX;
    }

    public static int multForUnsignedInt(int a, int b) {

        if (a == -MAX || b == -MAX) {
            return -MAX;
        }

        if (a >= 0 || b >= 0) {
            throw new ArithmeticException("mult: > " + 2L * MAX);
        }

        int result = a;

        for (int i = 1; i < b + MAX; i++) {
            result = sumForUnsignedInt(result, a);
        }

        return result;
    }

    public static int devForUnsignedInt(int a, int b) {

        if (b == -MAX) {
            throw new ArithmeticException("dev: /0 ");
        }

        int res = 0;
        while (a >= b) {
            res++;
            a = subForUnsignedInt(a, b);
        }
        return res - MAX;
    }

    public static int modForUnsignedInt(int a, int b) {

        if (b == -MAX) {
            throw new ArithmeticException("mod: /0 ");
        }

        while (a >= b) {
            a = subForUnsignedInt(a, b);
        }

        return a;
    }

    public static int toUnsignedInt(long number) {
        return (int) (number - MAX);
    }

    public static long fromUnsignedInt(int number) {
        return (long) number + MAX;
    }

    private static int readUnsignedIntFromTerminal() {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLong()) {
            long number = in.nextLong();
            if (number < 0 || number > 2L * MAX) {
                throw new ArithmeticException("Error number");
            }
            return toUnsignedInt(number);
        } else {
            throw new ArithmeticException("It's not number!");
        }
    }
}
