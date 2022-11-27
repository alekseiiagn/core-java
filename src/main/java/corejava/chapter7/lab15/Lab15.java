package corejava.chapter7.lab15;

import java.util.List;
import java.util.function.IntFunction;

public class Lab15 {

    public static void main(String[] args) {
        List<Integer> integers = toImmutableList(number -> number);
        for (int i = 0; i < 10; i++) {
            System.out.println(integers.get(i));
        }
        List<String> strings = toImmutableList(number -> "It is string #" + number);
        for (int i = 0; i < 10; i++) {
            System.out.println(strings.get(i));
        }
    }

    private static <T> List<T> toImmutableList(IntFunction<T> function) {
        return new ImmutableInfList<>(function);
    }
}
