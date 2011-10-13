package de.bripkens.fnd.ds;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public class ListTest {
    
    private List<Integer> list;
    
    @Before
    public void setUp() {
        list = new LinkedList<Integer>();
    }

    @Test
    public void testAdd() {
        Integer[] items = new Integer[]{42, 875, 43, 4, 777};
        for(int item : items) {
            list.add(item);
        }
        
        for(int i = 0; i < items.length; i++) {
            assertEquals(items[i], list.get(i));
        }
    }
    
    @Test
    public void testGetRecursive() {
        Integer[] items = new Integer[]{42, 875, 43, 4, 777};
        for(int item : items) {
            list.add(item);
        }
        
        for(int i = 0; i < items.length; i++) {
            assertEquals(items[i], list.getRecursive(i));
        }
    }

    @Test
    public void testGetItemWhichIsNotInList() {
        assertNull(list.get(42));
    }
    
    @Test
    public void testRemoveItem() {
        Integer[] items = new Integer[]{42, 875, 43, 4, 777};
        for(int item : items) {
            list.add(item);
        }
        
        int removedIndex = 1;
        list.remove(items[removedIndex]);
        
        for(int i = 0; i < items.length - 1; i++) {
            if (i < removedIndex) {
                assertEquals(items[i], list.get(i));
            } else {
                assertEquals(items[i+1], list.get(i));
            }
        }
    }

    @Test
    public void testIsEmpty() {
        Integer value = 42;
        assertTrue(list.isEmpty());
        list.add(value);
        assertFalse(list.isEmpty());
        list.remove(value);
        assertTrue(list.isEmpty());
    }
}
