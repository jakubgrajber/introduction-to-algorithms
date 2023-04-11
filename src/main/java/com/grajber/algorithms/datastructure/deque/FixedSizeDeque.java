package com.grajber.algorithms.datastructure.deque;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

public class FixedSizeDeque<T> implements Deque<T>{

    private final T[] deque;
    private final int capacity;
    private int head;
    private int tail;
    private int currentSize;

    public FixedSizeDeque(int capacity) {
        this.deque = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;
    }

    @Override
    public void enqueueHead(T element) throws OverflowException {
        head--;
        if (head < 0)
            head = capacity-1;
        if (head == tail)
            throw new OverflowException();
        currentSize++;
        deque[head] = element;
    }

    @Override
    public T dequeueHead() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        T result = deque[head++];
        currentSize--;
        if (head == capacity) head = 0;

        return result;

    }

    @Override
    public void enqueueTail(T element) throws OverflowException {
        if (currentSize == capacity) throw new OverflowException();

        deque[tail++] = element;
        currentSize++;
        if (tail == capacity) tail = 0;

    }

    @Override
    public T dequeueTail() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        currentSize--;
        return deque[--tail];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
