package de.bripkens.fnd.ds;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public class QueueTest {

    private Queue<Integer> queue;
    
    @Before
    public void setUp() {
        queue = new LinkedList<Integer>();
    }

    @Test
    public void testEnqueueSingleItem() {
        Integer first = 1;
        queue.enqueue(first);
        assertEquals(first, queue.dequeue());
    }
    
    @Test
    public void testEnqueueManyItems() {
        Integer first = 1, second = 5, third = 4;
        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);
        assertEquals(first, queue.dequeue());
        assertEquals(second, queue.dequeue());
        assertEquals(third, queue.dequeue());
    }
    
    @Test
    public void testDequeueTooManyItems() {
        Integer first = 1;
        queue.enqueue(first);
        assertEquals(first, queue.dequeue());
        assertNull(queue.dequeue());
        queue.enqueue(first);
        assertEquals(first, queue.dequeue());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(42);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
