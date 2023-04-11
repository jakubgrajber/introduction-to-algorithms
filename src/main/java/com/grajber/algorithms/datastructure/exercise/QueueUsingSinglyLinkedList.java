package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.common.Node;
import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;
import com.grajber.algorithms.datastructure.queue.Queue;

public class QueueUsingSinglyLinkedList<T> implements Queue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void enqueue(T element) throws OverflowException {
        if (isEmpty()) {
            head = tail = new Node<>(element);
        } else {
            tail.next(new Node<>(element));
            tail = tail.next();
        }
    }

    @Override
    public T dequeue() throws UnderflowException {
        var dequeued = head;
        head = head.next();
        return dequeued.data();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
