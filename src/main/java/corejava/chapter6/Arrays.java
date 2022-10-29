package corejava.chapter6;

import corejava.chapter6.lab7.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;

public class Arrays {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;
    private static final Random random = new Random();

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static <E extends Comparable<? super E>> List<E> createRandomArrayBySize(int count) {
        List<E> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Number number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
            out.add((E) number);
        }
        return out;
    }

    public static <E> Pair<E> firstLast(List<? extends E> list) {
        return new Pair<>(list.get(0), list.get(list.size() - 1));
    }


    public static <E extends Comparable<? super E>> E max(List<E> list) {
        E max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static <E extends Comparable<? super E>> E min(List<E> list) {
        E min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static <E extends Comparable<? super E>> Pair<E> minMax(List<E> list) {
        return new Pair<>(min(list), max(list));
    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) result[i] = obj;
        return result;
    }

    @SafeVarargs
    public static <T> T[] construct(int size, T... template) {
        return java.util.Arrays.copyOf(template, size);
    }
}
