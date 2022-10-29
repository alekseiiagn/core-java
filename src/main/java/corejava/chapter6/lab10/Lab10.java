package corejava.chapter6.lab10;

import corejava.chapter6.Arrays;

import java.util.List;

public class Lab10 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.createRandomArrayBySize(13);
        System.out.println(list);
        System.out.println("MAX: " + Arrays.max(list));
        System.out.println("MIN: " + Arrays.min(list));
    }
}
