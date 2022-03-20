package corejava.chapter2.lab16_17;

import java.util.NoSuchElementException;

public class Queue<T> {

    public class Iterator {
        private Node<T> ptr;
        private boolean flagFirst;

        Iterator(Node<T> first) {
            ptr = first;
            flagFirst = true;
        }

        boolean hasNext() {
            return ptr.next != null;
        }

        T remove() {
            if (ptr.prev == null) {
                ptr = ptr.next;
                return Queue.this.remove();
            }
            Node<T> del = ptr;
            ptr.prev.next = del.next;
            Queue.this.size--;
            return del.info;
        }

        T next() {
            if (flagFirst) {
                flagFirst = false;
                return ptr.info;
            }
            if (hasNext()) {
                T res = ptr.next.info;
                ptr = ptr.next;
                return res;
            } else {
                throw new NoSuchElementException("next = null");
            }
        }

        public T current() {
            return ptr.info;
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
            return info.toString();
        }
    }

    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    public Iterator iterator() {
        return new Iterator(first);
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

    public T remove() {
        if (size > 0) {
            Node<T> it = first;
            first = first.next;
            first.prev = null;
            size--;
            return it.info;
        }
        return null;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

/*    public T takeLast() {
        if (size > 0) {
            Node<T> it = last;
            last = last.prev;
            size--;
            return it.info;
        }
        return null;
    }*/

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> it = first;
        for (int i = 0; i < size; i++) {
            if (it.info == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(it);
            }
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
            it = it.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
