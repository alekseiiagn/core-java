package corejava.chapter2.lab16_17;

import java.util.NoSuchElementException;

public class Queue<T> {


    private static class Iterator<T> {
        Node<T> ptr;

        Iterator(Node<T> first) {
            ptr = first;
        }

        boolean hasNext() {
            return ptr.next != null;
        }

        T next() {
            if (hasNext()) {
                T res = ptr.next.info;
                ptr = ptr.next;
                return res;
            } else {
                throw new NoSuchElementException("next = null");
            }
        }
    }

    private static class Node<T> {
        Node<T> prev;
        T info;
        Node<T> next;

        Node(Node<T> prev, T info, Node<T> next) {
            this.prev = prev;
            this.info = info;
            this.next = next;
        }

        @Override
        public String toString() {
            return " Node{" +
                    " info:" + info +
                    " }";
        }
    }

    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    public Iterator<T> iterator() {
        return new Iterator<T>(first);
    }

    public void add(T info) {
        Node<T> node = new Node<>(last, info, null);
        if (size == 0) {
            first = node;
            last = node;
        }
        if (size > 0) {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Node<T> get() {
        if (size > 0) {
            Node<T> it = first;
            first = first.next;
            first.prev = null;
            size--;
            return it;
        }
        return null;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public Node<T> remove() {
        if (size > 0) {
            Node<T> it = last;
            last = last.prev;
            size--;
            return it;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> it = first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(it.toString());
            it = it.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
