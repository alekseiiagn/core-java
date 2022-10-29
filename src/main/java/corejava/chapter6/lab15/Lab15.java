package corejava.chapter6.lab15;

import corejava.chapter6.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Lab15 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.createRandomArrayBySize(10);
        List<String> strings = map(numbers, o -> o + "^2 = " + o * o);
        System.out.println(strings);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T elem : list) {
            result.add(function.apply(elem));
        }
        return result;
    }
}
