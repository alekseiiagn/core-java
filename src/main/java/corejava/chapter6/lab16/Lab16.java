package corejava.chapter6.lab16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lab16 {

    public static void main(String[] args) throws ClassNotFoundException {
        printMethodMax();
        Collection<String> list1 = new ArrayList<>();
        max(list1); // String extend Comparable, OK

        /*
        Collection<Object> list2 = new ArrayList<>();
        max(list2); // Object not extend Comparable, ERROR
        */
    }

    private static void printMethodMax() throws ClassNotFoundException {
        System.out.println(Class.forName("corejava.chapter6.lab16.Lab16").getMethods()[1]);
    }

//    public static <T extends Comparable<? super T>> void sort(List<T> list){}
//    public static void sort(List<Comparable<Object>> list){}

    public static <T extends Comparable<? super T>> void sort(List<T> list) {}

//    public static <T extends Object & Comparable<? super Т>> T max (Collections<? extends T> coll)
//    public static Object max(Collection<Object> coll)

    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return null;
    }

}
