package com.spodin.datastructures.list;

import org.junit.Test;

import java.util.NoSuchElementException;

public class ArrayListTest extends AbstractListTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInitialSizeCheck() {
        ArrayList arrayList = new ArrayList(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNext() {
        ArrayList arrayList = new ArrayList();
        arrayList.iterator().next();
    }

    @Override
    public List createList() {
        return new ArrayList<String>();
    }
}





