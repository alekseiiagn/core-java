package corejava.chapter1.lab9;

import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter string1:");
        String str1 = in.nextLine();
        System.out.print("Enter string2:");
        String str2 = in.nextLine();

        System.out.println("string1 == string2\nResult ignore case:" + str1.trim().equalsIgnoreCase(str2.trim()));
    }
}
