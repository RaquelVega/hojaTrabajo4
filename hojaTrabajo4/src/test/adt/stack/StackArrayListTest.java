package adt.stack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para StackArrayList.
 */
public class StackArrayListTest {

    private IStack<String> stack;

    @Before
    public void setUp() {
        stack = new StackArrayList<>();
    }

    @Test
    public void testPushAndPeek() {
        stack.push("10");
        assertEquals("10", stack.peek());
        stack.push("20");
        assertEquals("20", stack.peek());
    }

    @Test
    public void testPop() {
        stack.push("10");
        stack.push("20");
        assertEquals("20", stack.pop());
        assertEquals("10", stack.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("10");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    public void testClear() {
        stack.push("1");
        stack.push("2");
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test(expected = RuntimeException.class)
    public void testPopEmptyThrowsException() {
        stack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void testPeekEmptyThrowsException() {
        stack.peek();
    }
}