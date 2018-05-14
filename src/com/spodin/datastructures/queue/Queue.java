package com.spodin.datastructures.queue;

public interface Queue<E> {

    boolean add(E e);

    boolean offer(E e);

    E remove();

    E poll() throws InterruptedException;

    E element();

    E peek();
}
