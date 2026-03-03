package adt.list;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para SinglyLinkedList.
 */
public class SinglyLinkedListTest {

    private IList<String> list;

    @Before
    public void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void testAddAndGet() {
        list.add("A");
        list.add("B");
        list.add("C");
        // add agrega al inicio, entonces: C -> B -> A
        assertEquals("C", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("A", list.get(2));
    }

    @Test
    public void testRemove() {
        list.add("X");
        list.add("Y");
        list.add("Z");
        // Z -> Y -> X
        assertEquals("Z", list.remove(0));
        assertEquals(2, list.size());
        assertEquals("Y", list.get(0));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add("1");
        list.add("2");
        assertEquals(2, list.size());
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
        assertEquals(0, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        list.add("A");
        list.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        list.remove(0);
    }
}
    