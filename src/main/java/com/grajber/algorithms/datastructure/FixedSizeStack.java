package com.grajber.algorithms.datastructure;

import com.grajber.algorithms.datastructure.exception.StackOverflowException;
import com.grajber.algorithms.datastructure.exception.StackUnderflowException;

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
    public void push(T element) throws StackOverflowException {
        if (top + 1 == capacity)
            throw new StackOverflowException();
        stack[++top] = element;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (this.isEmpty())
            throw new StackUnderflowException();
        return stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
