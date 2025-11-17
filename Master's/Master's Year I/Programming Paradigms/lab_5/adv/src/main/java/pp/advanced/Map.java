package pp.advanced;

import java.util.LinkedList;

public interface Map<K, V> {
    void add (K key, V value);
    V remove (K key);
    int size();
    boolean isEmpty();
    LinkedList<K> keys();
    void print();
}