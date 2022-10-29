package corejava.chapter6.lab11;

import corejava.chapter6.Arrays;
import corejava.chapter6.lab7.Pair;

import java.util.List;

public class Lab11 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.createRandomArrayBySize(10);
        System.out.println(list);

        Pair<Integer> pair = Arrays.minMax(list);
        System.out.println("MIN: " + pair.getFirst());
        System.out.println("MAX: " + pair.getSecond());
    }
}
