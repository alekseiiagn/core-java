package corejava.chapter7.lab13;

public class Lab13 {

    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(5);
        for (int i = 0; i < 10; i++) {
            cache.put(i, "SomeValue");
        }
        System.out.println(cache);
    }
}
