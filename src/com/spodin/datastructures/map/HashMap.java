package com.spodin.datastructures.map;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashMap<K, V> {

    private ArrayList<Entry>[] mainList;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap() {
        mainList = (ArrayList<Entry>[]) new ArrayList[16];
        for (int i = 0; i < 16; i++) {
            mainList[i] = new ArrayList<Entry>();
        }
    }

    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        Entry entry = new Entry(key, value);

        int index = calculateIndex(key);

        for (Entry e : mainList[index]) {
            if (e.getKey().equals(key)) {
                e.setValue(value);
                return;
            }
        }
        mainList[index].add(entry);
        size++;
    }

    public V get(K key) {
        int index = calculateIndex(key);
        V result = null;

        for (Entry e : mainList[index]) {
            if (e.getKey().equals(key)) {
                result = e.getValue();
            }
        }
        return result;
    }

    public void remove(K key) {
        int index = calculateIndex(key);

        for (Entry e : mainList[index]) {
            if (e.getKey().equals(key)) {
                mainList[index].remove(e);
                size--;
                return;
            }
        }
        throw new NoSuchElementException("No such key");
    }

    public boolean containsKey(K key) {
        int index = calculateIndex(key);

        for (Entry e : mainList[index]) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }

        //if nothing found by this key
        return false;
    }

    public boolean containsValue(V value) {
        for (ArrayList<Entry> arrayList : mainList) {
            for (Entry e : arrayList) {
                if (e.getValue().equals(value)) {
                    return true;
                }
            }
        }

        //if nothing found by this key
        return false;
    }

    public List<K> keyList() {
        List<K> result = new ArrayList<K>();

        for (ArrayList<Entry> arrayList : mainList) {
            for (Entry e : arrayList) {
                result.add(e.getKey());
            }
        }

        return result;
    }

    public List<V> valueList() {
        List<V> result = new ArrayList<V>();

        for (ArrayList<Entry> arrayList : mainList) {
            for (Entry e : arrayList) {
                result.add(e.getValue());
            }
        }

        return result;
    }

    public int size() {
        return size;
    }

    private int calculateIndex(K obj) {
        return obj.hashCode() % 16;
    }

    private class Entry {

        private final K KEY;
        private V value;

        private Entry(K key, V value) {
            this.KEY = key;
            this.value = value;
        }

        public K getKey() {
            return KEY;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
