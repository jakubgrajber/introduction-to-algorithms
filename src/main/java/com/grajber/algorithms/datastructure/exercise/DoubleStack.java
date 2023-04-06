package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.exception.StackOverflowException;
import com.grajber.algorithms.datastructure.exception.StackUnderflowException;

/**
 * Exercise 10.1-3
 * @param <T> user defined type
 */
public class DoubleStack<T> {

    private final T[] storage;
    private final int capacity;
    private int leftTop;
    private int rightTop;

    public DoubleStack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException();

        this.storage = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.leftTop = -1;
        this.rightTop = capacity;
    }

    public void pushLeft(T element) throws StackOverflowException {
        if (leftTop + 1 == rightTop)
            throw new StackOverflowException();
        storage[++leftTop] = element;
    }

    public void pushRight(T element) throws StackOverflowException {
        if (rightTop - 1 == leftTop)
            throw new StackOverflowException();
        storage[--rightTop] = element;
    }

    public T popLeft() throws StackUnderflowException {
        if (this.isLeftEmpty())
            throw new StackUnderflowException();
        return storage[leftTop--];
    }

    public T popRight() throws StackUnderflowException {
        if (this.isRightEmpty())
            throw new StackUnderflowException();
        return storage[rightTop++];
    }

    public boolean isLeftEmpty() {
        return leftTop == -1;
    }

    public boolean isRightEmpty() {
        return rightTop == capacity;
    }

}
