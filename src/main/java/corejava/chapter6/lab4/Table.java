package corejava.chapter6.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table<K, V> {

    private final List<Entry> list;

    Table() {
        list = new ArrayList<>();
    }

    public void add(K key, V value) {
        list.add(new Entry(key, value));
    }

    public V get(K key) {
        return foundEntryByKeyOrThrowException(key).getValue();
    }

    private Entry foundEntryByKeyOrThrowException(K key) {
        for (Entry item : list) {
            if (item.getKey().equals(key))
                return item;
        }
        throw new RuntimeException("item not found");
    }

    public void set(K key, V value) {
        foundEntryByKeyOrThrowException(key).setValue(value);
    }

    public int size() {
        return list.size();
    }

    class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}

