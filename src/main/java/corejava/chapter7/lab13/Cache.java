package corejava.chapter7.lab13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> extends LinkedHashMap<K, V> {

    private final int maxEntries;

    public Cache(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }
}
