package corejava.chapter1.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab71 {

    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.printf("Enter 2 numbers [0;%d]: ", 2L * MAX);

        byte[] intNumber1 = readUnsignedIntFromTerminal();
        byte[] intNumber2 = readUnsignedIntFromTerminal();

        System.out.println("1: " + byteToString(intNumber1) + "\n2: " + byteToString(intNumber2));

        System.out.println("Result:" //+
                //"\n+ :" + fromUnsignedInt(sumForUnsignedInt(intNumber1, intNumber2)) +
                //"\n- :" + fromUnsignedInt(subForUnsignedInt(intNumber1, intNumber2)) +
                //"\n* :" + fromUnsignedInt(multForUnsignedInt(intNumber1, intNumber2)) //+
                //"\n/ :" + fromUnsignedInt(devForUnsignedInt(intNumber1, intNumber2)) +
                //"\n% :" + fromUnsignedInt(modForUnsignedInt(intNumber1, intNumber2))
        );
    }

    public static byte[] toByte(long number) {
        long highWorld;
        String str = Long.toString(number, 2);
        int size = 32 - str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(str);


        int start = 0;
        int finish = 8;
        System.out.println(stringBuilder);
        byte[] result = new byte[4];
        do {
            highWorld = Integer.parseInt(stringBuilder.substring(start, finish));
            result[start / 8] = Byte.parseByte(stringBuilder.substring(start, finish));
            start += 8;
            finish += 8;
        } while (finish != 32);
        return result;
    }

    public static String byteToString(byte[] number) {
        StringBuilder sb = new StringBuilder();
        for (byte it : number) {
            if (it == 0) {
                sb.append("00000000");
            } else {
                sb.append(Integer.toBinaryString(it));
            }
        }
        return sb.toString();
    }

    /*    public static int toUnsignedInt(long number) {
        return (int) (number - MAX);
    }

    public static long fromUnsignedInt(int number) {
        return (long) number + MAX;
    }*/

    private static byte[] readUnsignedIntFromTerminal() {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLong()) {
            long number = in.nextLong();
            if (number < 0 || number > 2L * MAX) {
                throw new ArithmeticException("Error number");
            }
            return toByte(number);
        } else {
            throw new ArithmeticException("It's not number!");
        }
    }
}

