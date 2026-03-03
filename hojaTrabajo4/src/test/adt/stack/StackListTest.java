package adt.stack;

import adt.list.SinglyLinkedList;
import adt.list.DoublyLinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para StackList con ambas implementaciones de lista.
 */
public class StackListTest {

    @Test
    public void testWithSinglyLinkedList() {
        IStack<String> stack = new StackList<>(new SinglyLinkedList<>());
        stack.push("10");
        stack.push("20");
        stack.push("30");

        assertEquals("30", stack.peek());
        assertEquals("30", stack.pop());
        assertEquals("20", stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testWithDoublyLinkedList() {
        IStack<String> stack = new StackList<>(new DoublyLinkedList<>());
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.peek());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    public void testClearWithSingly() {
        IStack<String> stack = new StackList<>(new SinglyLinkedList<>());
        stack.push("1");
        stack.push("2");
        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testClearWithDoubly() {
        IStack<String> stack = new StackList<>(new DoublyLinkedList<>());
        stack.push("X");
        stack.push("Y");
        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopEmptySingly() {
        IStack<String> stack = new StackList<>(new SinglyLinkedList<>());
        stack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void testPopEmptyDoubly() {
        IStack<String> stack = new StackList<>(new DoublyLinkedList<>());
        stack.pop();
    }
}