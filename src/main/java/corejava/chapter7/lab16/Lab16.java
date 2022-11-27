package corejava.chapter7.lab16;

public class Lab16 {

    public static void main(String[] args) {
        ImmutableInfList<Integer> integers = new ImmutableInfList<>(number -> number, 5);
        for (int i = 0; i < 10; i++) {
            System.out.println(integers.get(i));
        }
        ImmutableInfList<String> strings = new ImmutableInfList<>(number -> "It is string #" + number, 5);
        for (int i = 0; i < 10; i++) {
            System.out.println(strings.get(i));
        }
        System.out.println(integers.getCache());
        System.out.println(strings.getCache());
    }
}
