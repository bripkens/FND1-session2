package de.bripkens.fnd.ds;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public interface Stack<T> {

    boolean isEmpty();

    T pop();

    void push(T value);
    
}
