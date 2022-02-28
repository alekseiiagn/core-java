package corejava.chapter1.lab13;

import java.util.*;

public class Lab13 {
    public static void main(String[] args) {
        List<Integer> arr = createArray();
        System.out.println(arr);
        System.out.println(readCombination(arr));
        System.out.println(arr);
    }

    private static List<Integer> readCombination(List<Integer> arr) {
        Random rand = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            result.add(arr.remove(Math.abs(rand.nextInt(49 - i))));
        }
        return result;
    }

    private static List<Integer> createArray() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            arr.add(i);
        }
        return arr;
    }
}
