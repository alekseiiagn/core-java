package corejava.chapter7.lab5;

import java.util.*;

public class Lab5 {

    public static void main(String[] args) {
        int indexFrom = 20;
        int fromTo = 3500;
        int size = 5000;

        List<Integer> integersArr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integersArr.add(i);
        }
        swap(integersArr, indexFrom, fromTo);
        System.out.println(integersArr);

        List<Integer> integersLink = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            integersLink.add(i);
        }
        swap(integersLink, indexFrom, fromTo);
        System.out.println(integersLink);
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelp(list, i, j);
    }

    private static <T> void swapHelp(List<T> list, int i, int j) {
        if (list instanceof RandomAccess) {
            T o = list.get(i);
            list.set(i, list.get(j));
            list.set(j, o);
        } else {
            ListIterator<T> iteratorI = list.listIterator(i);
            ListIterator<T> iteratorJ = list.listIterator(j);
            T o = iteratorI.next();
            iteratorI.previous();
            iteratorI.set(iteratorJ.next());
            iteratorJ.previous();
            iteratorJ.set(o);
        }
    }
}
