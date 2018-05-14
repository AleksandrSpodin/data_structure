package com.spodin.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {

    }

    @Override
    public boolean add(E element, int index) {
        addIndexRangeCheck(index);

        if (index == 0) {
            addFirst(element);
            return false;
        } else if (index == size) {
            add(element);
            return false;
        }

        Node<E> target = first;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }

        Node<E> newNode = new Node<E>();
        newNode.item = element;
        newNode.prev = target.prev;
        newNode.next = target;
        target.prev.next = newNode;
        target.prev = newNode;

        size++;

        return true;
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<E>();
        newNode.item = element;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;

        return true;
    }

    public boolean addFirst(E element) {
        Node<E> newNode = new Node<E>();
        newNode.item = element;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;

        return true;
    }

    @Override
    public boolean add(E... args) {
        for (E element : args) {
            add(element);
        }

        return true;
    }

    @Override
    public E get(int index) {
        indexRangeCheck(index);

        Node<E> target = first;

        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.item;
    }

    @Override
    public int indexOf(E element) {
        Node<E> temp = first;

        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (temp.item == null) {
                    return i;
                }
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (temp.item != null) {
                    if (temp.item.equals(element)) {
                        return i;
                    }
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        Node<E> temp = last;
        int index = size - 1;

        if (element == null) {
            for (int i = index; i > 0; i--) {
                if (temp.item == null) {
                    return i;
                }
                temp = temp.prev;
            }
        } else {
            for (int i = size - 1; i > 0; i--) {
                if (temp.item != null) {
                    if (temp.item.equals(element)) {
                        return i;
                    }
                    temp = temp.prev;
                }
            }
        }

        return -1;
    }

    @Override
    public void set(E element, int index) {
        indexRangeCheck(index);

        Node<E> target = first;

        for (int i = 0; i < index; i++) {
            target = target.next;
        }

        target.item = element;
    }

    @Override
    public void remove(int index) {
        indexRangeCheck(index);

        if (size == 1) {
            first = null;
            last = null;
        } else if (index == 0) {
            first = first.next;
            first.prev = null;
        } else if (index == size - 1) {
            last = last.prev;
            last.next = null;
        } else {
            Node<E> target = first;
            for (int i = 0; i < index; i++) {
                target = target.next;
            }
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Node<E> temp = first;
        for (int i = 0; i < size; i++) {
            temp.item = null;
            temp = temp.next;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void addIndexRangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(indexOutOfBoundsMessage(index));
        }
    }

    private void indexRangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(indexOutOfBoundsMessage(index));
        }
    }

    private String indexOutOfBoundsMessage(int index) {
        return "index : " + index + ", size : " + size;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node() {
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        private int position = -1;

        private LinkedListIterator() {

        }

        @Override
        public boolean hasNext() {
            return size != 0 && position + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            position++;
            return get(position);
        }

        @Override
        public void remove() {
            LinkedList.this.remove(position);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node target = first;

        stringBuilder.append("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(target.item);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            target = target.next;
        }

        return stringBuilder.append("]").toString();
    }
}