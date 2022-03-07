package corejava.chapter2.lab2;

import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    public static void main (String[] argv){
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        //модифицирующий, т.к. вызывает метод setRadix();

        Random random = new Random();
        random.nextInt();
        //метод доступа, не изменяет поля
    }
}
