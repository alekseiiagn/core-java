package corejava.chapter6.lab8;

public class Lab8 {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(1, 5);

        System.out.println(pair.max());
        System.out.println(pair.min());
    }
}
