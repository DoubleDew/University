package pp.advanced;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MapImpl<K, V> implements Map<K, V> {
    private final LinkedList<K> keys;
    private final LinkedList<V> values;

    // Constructor: creates empty lists
    public MapImpl() {
        keys = new LinkedList<>();
        values = new LinkedList<>();
    }

    @Override
    public void add(K key, V value) {
        // Ensure key is unique
        if (keys.contains(key)) {
            System.out.println("Key \"" + key + "\" already exists. Value not added.");
            return;
        }
        keys.add(key);
        values.add(value);
    }

    @Override
    public V remove(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        keys.remove(index);
        return values.remove(index);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public LinkedList<K> keys() {
        return new LinkedList<>(keys); // return a copy to avoid modification outside
    }

    @Override
    public void print() {
        if (keys.isEmpty()) {
            System.out.println("(empty map)");
            return;
        }
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " => " + values.get(i));
        }
    }
}