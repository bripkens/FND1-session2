package de.bripkens.fnd.ds;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public class StackTest {
    
    private Stack<Integer> stack;
    
    @Before
    public void setUp() {
        stack = new LinkedList<Integer>();
    }

    @Test
    public void testSingleValue() {
        Integer value = 42;
        stack.push(value);
        assertEquals(value, stack.pop());
    }

    @Test
    public void testMultipleValues() {
        Integer first = 42, second = 84, third = 77;
        stack.push(first);
        stack.push(second);
        stack.push(third);
        assertEquals(third, stack.pop());
        assertEquals(second, stack.pop());
        assertEquals(first, stack.pop());
    }
    
    @Test
    public void testPopTooMany() {
        Integer value = 42;
        stack.push(value);
        assertEquals(value, stack.pop());
        assertNull(stack.pop());
        stack.push(value);
        assertEquals(value, stack.pop());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(42);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
