package corejava.chapter6.lab3;

import java.util.LinkedList;
import java.util.List;

public class Table<K, V> {

    private final List<Entry<K, V>> list;

    Table() {
        list = new LinkedList<>();
    }

    public void add(K key, V value) {
        list.add(new Entry<>(key, value));
    }

    public V get(K key) {
        return foundEntryByKeyOrThrowException(key).getValue();
    }

    private Entry<K, V> foundEntryByKeyOrThrowException(K key) {
        for (Entry<K, V> item : list) {
            if (item.getKey().equals(key))
                return item;
        }
        throw new RuntimeException("item not found");
    }

    public void set(K key, V value) {
        foundEntryByKeyOrThrowException(key).setValue(value);
    }

    public int size(){
        return list.size();
    }
}