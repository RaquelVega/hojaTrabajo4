package adt.list;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para DoublyLinkedList.
 */
public class DoublyLinkedListTest {

    private IList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testAddAndGet() {
        list.add("A");
        list.add("B");
        list.add("C");
        // add agrega al inicio: C -> B -> A
        assertEquals("C", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("A", list.get(2));
    }

    @Test
    public void testRemoveFirst() {
        list.add("X");
        list.add("Y");
        list.add("Z");
        // Z -> Y -> X
        assertEquals("Z", list.remove(0));
        assertEquals(2, list.size());
        assertEquals("Y", list.get(0));
    }

    @Test
    public void testRemoveLast() {
        list.add("A");
        list.add("B");
        list.add("C");
        // C -> B -> A
        assertEquals("A", list.remove(2));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveMiddle() {
        list.add("1");
        list.add("2");
        list.add("3");
        // 3 -> 2 -> 1
        assertEquals("2", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("3", list.get(0));
        assertEquals("1", list.get(1));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add("A");
        list.add("B");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        list.get(0);
    }
}