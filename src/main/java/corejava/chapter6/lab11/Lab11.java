package corejava.chapter6.lab11;

import corejava.chapter6.ArrayUtils;
import corejava.chapter6.lab7.Pair;

import java.util.List;

public class Lab11 {
    public static void main(String[] args) {
        List<Integer> list = ArrayUtils.createRandomArrayBySize(10);
        Pair<Integer> pair = ArrayUtils.minMax(list);

        System.out.println(list);
        System.out.println("MIN: " + pair.getFirst());
        System.out.println("MAX: " + pair.getSecond());
    }
}
