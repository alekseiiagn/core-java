package corejava.chapter6.lab5;

import java.util.Arrays;

public class Lab5 {
    public static void main(String[] args) {
//        Нужен cast потому что возвращается Object
//        Double[] result1 = Lab5.swap(0, 1, 1.5, 2, 3);

//        Нужно передавать только Double, так как мы его указали
//        Double[] result2 = Lab5.<Double>swap(0, 1, 1.5, 2, 3);

        Double[] result3 = (Double[]) Lab5.swap(0, 1, 1.5, 2, 3);

    }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}
