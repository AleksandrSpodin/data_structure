package com.spodin.datastructures.map;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Integer.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HashMapTest {

    private HashMap<String, Integer> hashMap;

    @Before
    public void setup() {
        hashMap = new HashMap<>();
    }

    @Test
    public void testPut() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);

        assertTrue(hashMap.containsKey("1"));
        assertTrue(hashMap.containsKey("2"));
        assertTrue(hashMap.containsKey("3"));
        assertTrue(hashMap.containsValue(111));
        assertTrue(hashMap.containsValue(222));
        assertTrue(hashMap.containsValue(333));
    }

    @Test
    public void testGet() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);

        assertEquals(valueOf(111), hashMap.get("1"));
        assertEquals(valueOf(222), hashMap.get("2"));
        assertEquals(valueOf(333), hashMap.get("3"));
    }

    @Test
    public void testContainsKey() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);

        assertTrue(hashMap.containsKey("1"));
        assertTrue(hashMap.containsKey("2"));
        assertTrue(hashMap.containsKey("3"));
    }

    @Test
    public void testContainsValue() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);

        assertTrue(hashMap.containsValue(valueOf(111)));
        assertTrue(hashMap.containsValue(valueOf(222)));
        assertTrue(hashMap.containsValue(valueOf(333)));
    }

    @Test
    public void testSize() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);

        assertTrue(hashMap.size() == 3);
    }

    @Test
    public void testKeyList() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);
        hashMap.put("4", 444);

        assertTrue(hashMap.keyList().size() == 4);
    }

    @Test
    public void testValueList() {
        hashMap.put("1", 111);
        hashMap.put("2", 222);
        hashMap.put("3", 333);
        hashMap.put("4", 444);
        hashMap.put("5", 555);

        assertTrue(hashMap.valueList().size() == 5);
    }

    @Test
    public void testRemove() {
        hashMap.put("1", 11);
        hashMap.put("2", 22);
        hashMap.put("3", 33);

        assertTrue(hashMap.valueList().size() == 3);

        hashMap.remove("1");

        assertTrue(hashMap.valueList().size() == 2);
    }
}
