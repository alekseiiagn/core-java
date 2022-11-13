package corejava.chapter6.additional.task2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //Producer
    public static <T> List<T> test1(A<? extends T> a, int i) {
        T n = a.call1(i);
        return Stream.generate(() -> n)
                .limit(1)
                .collect(Collectors.toList());
    }

    //Никто
    public static boolean test11(A<?> a, int i) {
        try {
            a.call1(i);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //Consumer
    public static <T> int test2(B<? super T> b, T o) {
        return b.call2(o);
    }

    //Никто
    public static int test21(B<?> b) {
        return b.call2(null);
    }

    //Никто
    public static int test3(C<?> c, String o) {
        return c.call4(o);
    }

    //Producer
    public static <T> T test3(C<? extends T> c, int i) {
        return c.call3(i);
    }
}
