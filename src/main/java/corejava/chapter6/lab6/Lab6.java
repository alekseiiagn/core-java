package corejava.chapter6.lab6;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab6 {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;
    private static final int COUNT = 5;
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Integer> in = createRandomArrayBySize(COUNT);
        List<Integer> out = createRandomArrayBySize(COUNT);

        addAllExtends(in, out);
        addAllSuper(in, out);

        System.out.println(in);
    }

    public static List<Integer> createRandomArrayBySize(int count) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            out.add(random.nextInt(MIN_NUMBER, MAX_NUMBER));
        }
        return out;
    }

    public static <E> void addAllExtends(List<? extends E> in, List<? extends E> out) {
        for (int i = 0; i < out.size(); i++) {
            E item = out.get(i);
            ((List<E>) in).add(item);
        }
    }

    public static <E> void addAllSuper(List<? super E> in, List<? super E> out) {
        for (int i = 0; i < out.size(); i++) {
            E item = (E) out.get(i);
            in.add(item);
        }
    }
}
