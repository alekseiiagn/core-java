package corejava.chapter6.additional.task1;

public class Generic<T extends String> {
    private final T value;

    public Generic(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}