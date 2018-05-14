package com.spodin.datastructures.list;

public interface List<E> extends Iterable<E> {

    boolean add(E element, int index);

    boolean add(E element);

    boolean add(E... args);

    Object get(int index);

    int indexOf(E element);

    int lastIndexOf(E element);

    void set(E element, int index);

    void remove(int index);

    boolean contains(E element);

    boolean isEmpty();

    void clear();

    int size();
}
