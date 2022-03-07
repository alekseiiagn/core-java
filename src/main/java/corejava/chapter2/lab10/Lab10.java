package corejava.chapter2.lab10;

import java.util.LinkedList;
import java.util.List;

//Можно, но актуально ли это? Массивы не ответственны за эти задачи.
public class Lab10 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 7, 8};

        List<Integer> list = new LinkedList<>();
        for (Integer num : arr) {
            list.add(num);
        }

        System.out.println("[] = " + RandomNumber.randomElement(arr) +
                "\nlist = " + RandomNumber.randomElement(list));
    }
}
