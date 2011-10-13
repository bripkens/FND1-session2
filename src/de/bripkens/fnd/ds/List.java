package de.bripkens.fnd.ds;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public interface List<T> {

    void add(T value);

    T get(int index);
    
    T getRecursive(int index);

    boolean isEmpty();
    
    void remove(T value);
}
