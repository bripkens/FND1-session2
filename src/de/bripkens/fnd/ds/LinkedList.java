package de.bripkens.fnd.ds;

import java.util.NoSuchElementException;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public class LinkedList<T> implements Queue<T>, Stack<T>, List<T> {
    
    private final Node<T> head, tail;

    public LinkedList() {
        head = new Node<T>();
        tail = new Node<T>();
        
        head.next = tail;
        head.prev = head;
        tail.prev = head;
        tail.next = tail;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node();
        newNode.value = value;
        
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }
    
    @Override
    public T get(int index) {
        Node<T> currentNode = head;
        
        for(int indexCounter = 0;
                currentNode.next != tail && indexCounter < index;
                indexCounter++) {
            currentNode = currentNode.next;
        }
        
        return currentNode.next.value;
    }
    
    
    @Override
    public T getRecursive(int index) {
        return getRecursive(index, 0, head.next);
    }
    
    private T getRecursive(int index, int currentIndex, Node<T> currentNode) {
        if (index == currentIndex) {
            return currentNode.value;
        } else if (currentNode != tail) {
            return getRecursive(index, currentIndex + 1, currentNode.next);
        } else {
            throw new NoSuchElementException();
        }
    }
    
    @Override
    public void remove(T value) {
        for(Node<T> currentNode = head;
                currentNode.next != tail;
                currentNode = currentNode.next) {
            
            if (currentNode.next.value.equals(value)) {
                currentNode.next.next.prev = currentNode;
                currentNode.next = currentNode.next.next;
            }
            
        }
    }
    
    @Override
    public boolean isEmpty() {
        return head.next == tail;
    }
    
    @Override
    public void enqueue(T value) {
        add(value);
    }
    
    @Override
    public T dequeue() {
        T result = head.next.value;
        
        head.next.next.prev = head;
        head.next = head.next.next;
        
        return result;
    }
    
    @Override
    public void push(T value) {
        enqueue(value);
    }
    
    @Override
    public T pop() {
        T result = tail.prev.value;
        
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        
        return result;
    }

    private class Node <T> {
        private T value;
        private Node<T> next, prev;
    }
}
