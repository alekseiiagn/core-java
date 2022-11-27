package corejava.chapter7.lab16;

import corejava.chapter7.lab13.Cache;

import java.util.*;
import java.util.function.IntFunction;

public class ImmutableInfList<T> implements List<T> {

    private final Cache<Integer, T> cache;
    private final IntFunction<T> function;

    public ImmutableInfList(IntFunction<T> function, int cacheSize) {
        cache = new Cache<>(cacheSize);
        this.function = function;
    }

    public Map<Integer, T> getCache() {
        return Map.copyOf(cache);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T get(int index) {
        if (!cache.containsKey(index)) {
            cache.put(index, function.apply(index));
        }
        return cache.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<>() {

            private int curr = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                if (!cache.containsKey(curr)) {
                    cache.put(curr, function.apply(curr));
                }
                return cache.get(curr++);
            }

            @Override
            public boolean hasPrevious() {
                return true;
            }

            @Override
            public T previous() {
                --curr;
                if (!cache.containsKey(curr)) {
                    cache.put(curr, function.apply(curr));
                }
                return cache.get(curr);
            }

            @Override
            public int nextIndex() {
                return curr + 1;
            }

            @Override
            public int previousIndex() {
                return curr - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T obj) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(T obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        ListIterator<T> iterator = listIterator();
        while (iterator.nextIndex() != index) {
            iterator.next();
        }
        return iterator;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        indexOf(o);
        return true;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }
}
