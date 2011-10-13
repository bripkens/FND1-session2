package de.bripkens.fnd.ds;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public interface Queue<T> {

    T dequeue();

    void enqueue(T value);

    boolean isEmpty();
    
}
