package corejava.chapter6.lab2;

import corejava.chapter6.CustomStack;

import java.util.Arrays;
import java.util.function.Function;

public class StackGeneric<E> implements CustomStack<E> {
    private E[] array;
    private int count;
    private final double INCREASE_NUMBER = 1.5;

    StackGeneric() {
        array = (E[]) new Object[10];
        count = 0;
    }

    StackGeneric(Function<Integer, E[]> constr) {
        array = constr.apply(10);
        count = 0;
    }

    public void push(E item) {
        if (count + 1 == array.length) {
            increase();
        }
        array[count++] = item;
    }

    private void increase() {
        array = Arrays.copyOf(array, (int) (array.length * INCREASE_NUMBER));
    }

    public E pop() {
        if (count - 1 < 0) {
            throw new RuntimeException("array is empty");
        }
        return array[count--];
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
