package corejava.chapter6.lab9;

import corejava.chapter6.Arrays;
import corejava.chapter6.lab7.Pair;

import java.util.List;

public class Lab9 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.createRandomArrayBySize(13);
        System.out.println(list);

        Pair<Integer> pair = Arrays.firstLast(list);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

    }
}
