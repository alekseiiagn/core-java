package corejava.chapter6.additional;

import corejava.chapter6.lab19.Lab19;

import java.util.Arrays;
import java.util.List;

public class ToArray {

    public static void main(String[] args) {

        // Какой метод лучше и почему?
        //    1. Object[] toArray();
        //    2. <T> T[] toArray(T[] a);
        //    3. default <T> T[] toArray(IntFunction<T[]> generator) (внутри использует предыдущий метод)

        // 1 - когда хотим получить Object[]
        // 2 - когда хотим получить массив определенных объектов и имеет массив уже
        // 3 - когда хотим получить массив определенных объектов и хотим здать метод для создания массива

        List<String> randomList = Lab19.repeat(5, "rand");

        System.out.println(randomList.toArray());
        System.out.println(randomList.toArray(new String[0]));
        System.out.println(randomList.toArray(String[]::new));
        System.out.println(randomList.toArray((value) -> {
            String[] array = new String[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = i + "";
            }
            return array;
        }));

        System.out.println(Arrays.toString(randomList.toArray()));
        System.out.println(Arrays.toString(randomList.toArray(new String[0])));
        System.out.println(Arrays.toString(randomList.toArray(String[]::new)));
        System.out.println(Arrays.toString(randomList.toArray((value) -> {
            String[] array = new String[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = i + "";
            }
            return array;
        })));
    }
}
