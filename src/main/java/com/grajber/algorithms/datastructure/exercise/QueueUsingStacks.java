package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.FixedSizeStack;
import com.grajber.algorithms.datastructure.Queue;
import com.grajber.algorithms.datastructure.Stack;
import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

/**
 * Exercise 10.1-7
 */
public class QueueUsingStacks<T> implements Queue<T> {

    private final Stack<T> inbox;
    private final Stack<T> outbox;

    public QueueUsingStacks(int capacity) {
        this.inbox = new FixedSizeStack<>(capacity);
        this.outbox = new FixedSizeStack<>(capacity);
    }

    /**
     * Time complexity O(1)
     * @param element to enqueue
     * @throws OverflowException when queue is full
     */
    @Override
    public void enqueue(T element) throws OverflowException {
        inbox.push(element);
    }

    /**
     * Amortized time complexity O(1)
     * In the worst case O(n) - when we have to empty the whole of inbox stack into outbox stack
     * @return first element of queue
     * @throws UnderflowException - when queue is empty
     */
    @Override
    public T dequeue() throws UnderflowException {
        if (inbox.isEmpty() && outbox.isEmpty())
            throw new UnderflowException();
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

    @Override
    public boolean isEmpty() {
        return inbox.isEmpty();
    }
}
