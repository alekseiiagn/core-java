package corejava.chapter1.lab10;

import java.util.Random;

public class Lab10 {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.print(Long.toUnsignedString(rand.nextLong(), 36));
    }
}
