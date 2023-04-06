package com.grajber.algorithms.datastructure;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

public class FixedSizeStack<T> implements Stack<T>{

    private final T[] stack;
    private final int capacity;
    private int top;

    @SuppressWarnings("unchecked")
    public FixedSizeStack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException();

        this.stack = (T[]) new Object[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    @Override
    public void push(T element) throws OverflowException {
        if (top + 1 == capacity)
            throw new OverflowException();
        stack[++top] = element;
    }

    @Override
    public T pop() throws UnderflowException {
        if (this.isEmpty())
            throw new UnderflowException();
        return stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
