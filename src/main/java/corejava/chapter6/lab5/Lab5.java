package corejava.chapter6.lab5;

import corejava.chapter6.Arrays;

public class Lab5 {
    public static void main(String[] args) {
//        Нужен cast потому что возвращается Object
        Double[] result1 = (Double[]) Arrays.swap(0, 1, 1.5, 2, 3);

//        Нужно передавать только Double, так как мы его указали
        Double[] result2 = Arrays.<Double>swap(0, 1, 1.5, 2.0, 3.0);
    }
}
