package corejava.chapter6.lab12_13;

import corejava.chapter6.ArrayUtils;

import java.util.Comparator;
import java.util.List;

public class Lab12_13 {
    public static void main(String[] args) {
        List<Integer> elements = ArrayUtils.createRandomArrayBySize(13);
        System.out.println(elements);

        List<Integer> result = ArrayUtils.createRandomArrayBySize(3);
        System.out.println(result);

        minmax(elements, (o1, o2) -> o1 - o2, result);
        System.out.println(result);

    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        result.add(getMin(elements, comp));
        result.add(getMax(elements, comp));
    }

    private static <T> T getMin(List<T> elements, Comparator<? super T> comp) {
        T min = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (comp.compare(min, elements.get(i)) > 0) {
                min = elements.get(i);
            }
        }
        return min;
    }

    private static <T> T getMax(List<T> elements, Comparator<? super T> comp) {
        T max = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (comp.compare(max, elements.get(i)) < 0) {
                max = elements.get(i);
            }
        }
        return max;
    }

    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        //Lists.swapHelper(result, 0, 1); //Это вообще что такое?
    }


}
