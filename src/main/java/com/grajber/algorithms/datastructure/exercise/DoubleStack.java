package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

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

    public void pushLeft(T element) throws OverflowException {
        if (leftTop + 1 == rightTop)
            throw new OverflowException();
        storage[++leftTop] = element;
    }

    public void pushRight(T element) throws OverflowException {
        if (rightTop - 1 == leftTop)
            throw new OverflowException();
        storage[--rightTop] = element;
    }

    public T popLeft() throws UnderflowException {
        if (this.isLeftEmpty())
            throw new UnderflowException();
        return storage[leftTop--];
    }

    public T popRight() throws UnderflowException {
        if (this.isRightEmpty())
            throw new UnderflowException();
        return storage[rightTop++];
    }

    public boolean isLeftEmpty() {
        return leftTop == -1;
    }

    public boolean isRightEmpty() {
        return rightTop == capacity;
    }

}
