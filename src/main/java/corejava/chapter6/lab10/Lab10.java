package corejava.chapter6.lab10;

import corejava.chapter6.ArrayUtils;

import java.util.List;

public class Lab10 {

    public static void main(String[] args) {
        List<Integer> list = ArrayUtils.createRandomArrayBySize(13);
        System.out.println(list);
        System.out.println("MAX: " + ArrayUtils.max(list));
        System.out.println("MIN: " + ArrayUtils.min(list));
    }
}
