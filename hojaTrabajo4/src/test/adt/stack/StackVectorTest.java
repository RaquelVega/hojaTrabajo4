package adt.stack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para StackVector.
 */
public class StackVectorTest {

    private IStack<String> stack;

    @Before
    public void setUp() {
        stack = new StackVector<>();
    }

    @Test
    public void testPushAndPeek() {
        stack.push("A");
        assertEquals("A", stack.peek());

        stack.push("B");
        assertEquals("B", stack.peek());
    }

    @Test
    public void testPop() {
        stack.push("X");
        stack.push("Y");

        assertEquals("Y", stack.pop());
        assertEquals("X", stack.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("1");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push("1");
        stack.push("2");
        assertEquals(2, stack.size());
    }

    @Test
    public void testClear() {
        stack.push("A");
        stack.push("B");
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopEmptyThrowsException() {
        stack.pop();
    }
}