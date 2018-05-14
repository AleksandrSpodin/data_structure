package com.spodin.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.*;


public abstract class AbstractListTest {
    private List<Object> list;

    @Before
    public void before() {
        list = createList();
    }

    public abstract List createList();

    @Test
    public void testAddWithIndex() throws Exception {
        assertTrue(list.isEmpty());

        list.add("A", 0);
        list.add("B", 1);
        assertTrue(list.size() == 2);
        assertEquals("A", list.get(0));

        list.add("C", 2);
        assertTrue(list.size() == 3);
        assertEquals("C", list.get(2));

        list.add(null, 3);
        assertEquals(null, list.get(3));
        assertTrue(list.size() == 4);

        list.add('D', 'F', 'T', 'H', 'M', 'X');
        assertTrue(list.size() == 10); // Массив заполнен , 10 из 10

        list.add("hi world!", 10);
        assertTrue(list.size() == 11);
    }

    @Test
    public void testAddWithoutIndex() throws Exception {
        assertTrue(list.isEmpty());

        list.add("A");
        list.add("B");
        assertTrue(list.size() == 2);
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));

        list.add("C");
        assertTrue(list.size() == 3);
        assertEquals("C", list.get(2));
    }

    @Test
    public void testAddAll() throws Exception {
        assertTrue(list.isEmpty());

        list.add("A", "B", "C", "D", "E");
        assertTrue(list.size() == 5);
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

        list.add("F", 5);
        assertTrue(list.size() == 6);
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("F", list.get(5));

        list.add(null, null, null);
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add("A", 0);
        list.add("B", 1);
        assertTrue(list.indexOf("A") == 0);
        assertTrue(list.indexOf("B") == 1);
        assertTrue(list.size() == 2);

        list.set(null, 1);
        assertTrue(list.indexOf(null) == 1);

        list.add("FIRST ELEMENT", 0);
        assertTrue(list.indexOf("FIRST ELEMENT") == 0);

        list.add("THIRD ELEMENT", 2);
        assertTrue(list.indexOf("THIRD ELEMENT") == 2);

        list.add("LAST ELEMENT");
        assertTrue(list.indexOf("LAST ELEMENT") == list.size() - 1);

        list.set(null, 0);
        list.set(null, 3);
        assertTrue(list.size() == 5);
        assertTrue(list.indexOf(null) == 0);

        list.add("NEW FIRST ELEMENT", 0);
        assertTrue(list.size() == 6);
        assertTrue(list.indexOf(null) == 1);
    }

    @Test
    public void testLastIndexOf() throws Exception {
        assertTrue(list.isEmpty());

        list.add("A", 0);
        list.add("B", 1);
        list.add("A", 2);
        assertEquals("A", list.get(2));
        assertTrue(list.lastIndexOf("A") == 2);

        list.add("as");
        assertTrue(list.lastIndexOf("as") == 3);

        list.set(null, 0);
        list.set(null, 2);
        assertTrue(list.lastIndexOf(null) == 2);
    }

    @Test
    public void testGet() throws Exception {
        list.add("A", "B", "C");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testSet() throws Exception {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        list.add("D", 3);
        list.add("E", 4);
        assertTrue(list.indexOf("A") == 0);

        list.set("Chelsea FC", 0);
        assertTrue(list.indexOf("Chelsea FC") == 0);

        list.set(null, 0);
        assertTrue(list.indexOf(null) == 0);
    }

    @Test
    public void testRemove() throws Exception {
        list.add("A", "B", "C", "D", "E", "F", "G", "H", "T", "R");
        assertTrue(list.size() == 10);
        assertEquals("C", list.get(2));

        //Array is full , removing C
        list.remove(2);
        assertTrue(list.size() == 9);
        assertEquals("D", list.get(2));

        //Array is not full , removing B
        assertEquals("B", list.get(1));
        list.remove(1);
        assertTrue(list.size() == 8);
        assertEquals("D", list.get(1));

        list.remove(0);
        assertTrue(list.size() == 7);
        assertEquals(list.get(0), "D");

        list.remove(list.size() - 1);
        assertTrue(list.size() == 6);
        assertEquals(list.get(list.size() - 1), "T");
    }

    @Test
    public void testContains() throws Exception {
        list.add("A", "B", "C");
        assertTrue(list.contains("B"));

        list.remove(1);
        assertFalse(list.contains("B"));

        list.add("B");
        assertTrue(list.contains("B"));

        list.add(null, 3);
        assertTrue(list.contains(null));

        list.remove(list.indexOf(null));
        assertFalse(list.contains(null));
    }

    @Test
    public void testIsEmpty() throws Exception {
        list.add("A", "B");
        assertFalse(list.isEmpty());

        list.remove(0);
        list.remove(0);
        assertTrue(list.isEmpty());

        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() throws Exception {
        list.add(1, 2, 3);
        assertTrue(list.size() == 3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testListIterator() {
        Iterator iterator = list.iterator();

        list.add(1, 2, 3);
        assertTrue(list.size() == 3);
        assertTrue(iterator.hasNext());

        iterator.next();

        iterator.remove();
        assertTrue(list.size() == 2);
        assertTrue(iterator.hasNext());

        iterator.remove();
        assertTrue(list.size() == 1);
        assertFalse(iterator.hasNext()); //last element , no next elements exist

        iterator.remove();
        assertTrue(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexException() {
        list.add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertTrue(list.size() == 10);// коллекция заполнена , последний индекс = 9
        list.add(11, 11);// для добавления доступны индексы 9 и 10 , пробуем добавить в 11 - получаем исключение
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        list.add('a', 'b');
        assertTrue(list.size() == 2); // для метода get доступны индексы 0 и 1
        list.get(2); // пробуем достать элемент по индексу 2 - получаем исключение
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExcetpion() {
        assertTrue(list.isEmpty()); //сейчас коллекция пустая , для метода set доступен только индекс 0
        list.set("hi world", 1); // пробуем засэтить в 1 - получаем исключение
        list.add(1, 2, 3, 4, 5); // в коллекции 5 элементов , последний индекс = 4 , для сэта доступны индексы : 4 и 5
        list.set('F', 7); // пробуем засетить в 7 - получаем исключение
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExcetpion() {
        list.add("hey", "hi", "privet", "hello");
        assertTrue(list.size() == 4); // в коллекции 4 элемента
        // для метода remove доступны индексы : 0 , 1 , 2 , 3
        list.remove(4); // пробуем удалить элемент по индексу 4 - получаем  иключение
    }
}
