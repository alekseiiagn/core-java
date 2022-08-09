package corejava.chapter5.lab12;

import java.util.Arrays;
import java.util.Random;

public class Lab12 {

    private static final int MAX_NUMBER = 10000;

    public static void main(String[] args) {
        int[] array = generateRandomArrayBySize(100000000);
        //System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        System.out.println(min(array));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    /**
     * aleksejagnenkov@192 lab12 % java -ea Lab12.java<p>
     * 0<p>
     * Time: 139<p>
     * aleksejagnenkov@192 lab12 % java -ea Lab12.java<p>
     * 0<p>
     * Time: 138<p>
     * aleksejagnenkov@192 lab12 % java -ea Lab12.java<p>
     * 0<p>
     * Time: 140<p>
     * aleksejagnenkov@192 lab12 % java -da Lab12.java<p>
     * 0<p>
     * Time: 67<p>
     * aleksejagnenkov@192 lab12 % java -da Lab12.java<p>
     * 0<p>
     * Time: 71<p>
     * aleksejagnenkov@192 lab12 % java -da Lab12.java<p>
     * 0<p>
     * Time: 70<p>
     * aleksejagnenkov@192 lab12 %<p>
     */
    public static int min(int[] values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("values.length == 0");
        }
        int minNumber = Arrays.stream(values).min().getAsInt();
        assert Arrays.stream(values).allMatch(value -> value >= minNumber);
        return minNumber;
    }

    public static int[] generateRandomArrayBySize(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(MAX_NUMBER);
        }
        return array;
    }
}
