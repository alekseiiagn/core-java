package corejava.chapter6;

public interface CustomStack<E> {

    void push(E item);
    E pop();
    boolean isEmpty();

}
