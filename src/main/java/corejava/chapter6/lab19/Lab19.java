package corejava.chapter6.lab19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab19 {
    public static void main(String[] args) {
        List<Integer> list = repeat(10, 10);

        Integer[] array = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
    }

    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(obj);
        return result;
    }
}
