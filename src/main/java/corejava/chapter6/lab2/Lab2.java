package corejava.chapter6.lab2;

import corejava.chapter6.CustomStack;

public class Lab2 {

    private static final int COUNT = 13;

    public static void main(String[] args) {

        CustomStack<Integer> integerStackGeneric = new StackGeneric<>();
        fillByIntegers(integerStackGeneric);
        System.out.println(integerStackGeneric.isEmpty());
        deleteItems(integerStackGeneric);
        System.out.println(integerStackGeneric.isEmpty());

        CustomStack<Integer> integerStackWithObjects = new StackWithObjects<>();
        fillByIntegers(integerStackWithObjects);
        System.out.println(integerStackWithObjects.isEmpty());
        deleteItems(integerStackWithObjects);
        System.out.println(integerStackWithObjects.isEmpty());
    }


    private static void deleteItems(CustomStack<?> stack) {
        for (int i = 0; i < COUNT; i++) {
            stack.pop();
        }
    }

    private static void fillByIntegers(CustomStack<Integer> stack) {
        for (int i = 0; i < COUNT; i++) {
            stack.push(i);
        }
    }
}
