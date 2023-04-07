package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.FixedSizeQueue;
import com.grajber.algorithms.datastructure.Queue;
import com.grajber.algorithms.datastructure.Stack;
import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

/**
 * Exercise 10.1-8
 */
public class StackUsingQueues<T> implements Stack<T> {

    private Queue<T> q1;
    private Queue<T> q2;

    public StackUsingQueues(int capacity) {
        this.q1 = new FixedSizeQueue<>(capacity);
        this.q2 = new FixedSizeQueue<>(capacity);
    }

    /**
     * Time complexity O(n) as we need to move all elements to the second queue
     * @param element to push
     * @throws OverflowException when stack is full
     */
    @Override
    public void push(T element) throws OverflowException {
        q2.enqueue(element);

        while (!q1.isEmpty())
            q2.enqueue(q1.dequeue());

        var temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Time complexity O(1)
     * @return top element
     * @throws UnderflowException when stack is empty
     */
    @Override
    public T pop() throws UnderflowException {
        return q1.dequeue();
    }

    @Override
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
