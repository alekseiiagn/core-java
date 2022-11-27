package corejava.chapter7.lab14;

import corejava.chapter6.Arrays;

import java.util.Collections;
import java.util.List;

public class Lab14 {

    public static void main(String[] args) {
        int n = 4;
        List<Integer> list = Arrays.createRandomArrayBySize(10);
        System.out.println("List: " + list);
        List<Integer> view = getView(list, 0, n);
        System.out.println("View: " + view);
        System.out.println("Try to insert 0 in view:");
        view.add(0);
        System.out.println("View: " + view);
    }

    private static List<Integer> getView(List<Integer> list, int fromIndex, int toIndex) {
        return Collections.unmodifiableList(list.subList(fromIndex, toIndex));
    }
}
