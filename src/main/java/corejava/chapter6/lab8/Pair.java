package corejava.chapter6.lab8;

public class Pair<E extends Number & Comparable<? super E>> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public E max() {
        return first.compareTo(second) > 0 ? first : second;
    }

    public E min() {
        return first.compareTo(second) < 0 ? first : second;
    }
}
