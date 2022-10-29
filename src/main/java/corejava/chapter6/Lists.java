package corejava.chapter6;

import java.util.List;

public class Lists {
    public static <T> void swapHelper(List<T> result, int i, int j) {
        T obj = result.get(i);
        result.set(i, result.get(j));
        result.set(j, obj);
    }
}
