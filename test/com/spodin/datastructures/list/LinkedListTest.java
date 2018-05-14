package com.spodin.datastructures.list;

import org.junit.Test;

import java.util.NoSuchElementException;

public class LinkedListTest extends AbstractListTest {

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNext() {
        LinkedList linkedList = new LinkedList();
        linkedList.iterator().next();
    }

    @Override
    public List createList() {
        return new LinkedList();
    }
}
