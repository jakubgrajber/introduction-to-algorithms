package com.grajber.algorithms.datastructure.queue;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

public class FixedSizeQueue<T> implements Queue<T> {

    private final T[] queue;
    private final int capacity;
    private int head;
    private int tail;
    private int currentSize;

    public FixedSizeQueue(int capacity) {
        this.queue = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;
    }

    @Override
    public void enqueue(T element) throws OverflowException {
        if (currentSize == capacity) throw new OverflowException();

        queue[tail++] = element;
        currentSize++;
        if (tail == capacity) tail = 0;
    }

    @Override
    public T dequeue() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        T result = queue[head++];
        currentSize--;
        if (head == capacity) head = 0;

        return result;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
