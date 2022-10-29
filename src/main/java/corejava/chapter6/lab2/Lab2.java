package corejava.chapter6.lab2;

import corejava.chapter6.CustomStack;

public class Lab2 {

    private static final int COUNT = 13;

    public static void main(String[] args) {

        CustomStack<Integer> stackGenericCast = new StackGeneric<>();
        fillByIntegers(stackGenericCast);
        System.out.println(stackGenericCast.isEmpty());
        deleteItems(stackGenericCast);
        System.out.println(stackGenericCast.isEmpty());

        CustomStack<Integer> stackGeneric = new StackGeneric<>(Integer[]::new);
        fillByIntegers(stackGeneric);
        System.out.println(stackGeneric.isEmpty());
        deleteItems(stackGeneric);
        System.out.println(stackGeneric.isEmpty());

        CustomStack<Integer> stackWithObjects = new StackWithObjects<>();
        fillByIntegers(stackWithObjects);
        System.out.println(stackWithObjects.isEmpty());
        deleteItems(stackWithObjects);
        System.out.println(stackWithObjects.isEmpty());
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
