package corejava.chapter6.lab18;

import corejava.chapter6.Arrays;

public class Lab18 {
    public static void main(String[] args) {
        //нужно использовать box-типы
        System.out.println(java.util.Arrays.toString(Arrays.repeat(10,42, Integer[]::new)));

        //либо создавать методы под каждый из примитивных типов
    }
}
