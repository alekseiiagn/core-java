package corejava.chapter6.lab19;

import java.util.ArrayList;

public class Lab19 {
    //todo нельзя, почему?
    public static void main(String[] args) {
        ArrayList<Integer> list = repeat(10, 10);
        //нельзя, потому что list хранит внутри объекты в виде Object[]. Это поле private.

        //Если вызвать list.toArray(), то внутри метод использует getClass(),
        // потому что ему нужно понять во что кастить Object[]
    }

    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(obj);
        return result;
    }
}
