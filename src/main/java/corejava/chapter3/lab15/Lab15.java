package corejava.chapter3.lab15;

import corejava.chapter3.lab4_5.IntSequence;

import java.util.Comparator;

public class Lab15 {
    public static void main(String[] args) {
        IntSequence randomSequence = new IntSequence.RandomSequence(10, 100);
        for (int i = 0; i < 100; i++) {
            System.out.println(randomSequence.next());
        }
    }
}
