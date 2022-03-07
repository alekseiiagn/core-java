package corejava.chapter2.lab10;

import java.util.List;
import java.util.Random;

public class RandomNumber {
    static final Random random = new Random(Integer.MAX_VALUE);

    public static int randomElement(List<Integer> arr) {
        if (arr.size() > 0)
            return arr.get(random.nextInt(Integer.MAX_VALUE) % arr.size());
        return 0;
    }

    public static int randomElement(int[] arr) {
        if (arr.length > 0)
            return arr[random.nextInt(Integer.MAX_VALUE) % arr.length];
        return 0;
    }
}
