package com.spodin.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SynchronizedQueueTest {

    private SynchronizedQueue queue;
    private String TEST1 = "Test1";
    private String TEST2 = "Test2";

    @Before
    public void setUp() throws Exception {
        queue = new SynchronizedQueue();
    }

    @Test
    public void testAdd() {
        queue.add(TEST1);
        assertEquals(queue.get(0), TEST1);
    }

    @Test
    public void testOffer() {
        queue.offer(TEST1);
        assertEquals(queue.get(0), TEST1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove() {
        queue.remove();

    }

    @Test
    public void testPoll() {
        queue.add(TEST1);
        queue.add(TEST2);
        queue.remove();
        assertEquals(queue.get(0), TEST2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testElement() {
        queue.element();
    }

    @Test
    public void testPeek() {
        queue.add(TEST1);
        assertEquals(queue.peek(), TEST1);
        queue.remove(0);
        assertNull(queue.peek());
    }

}