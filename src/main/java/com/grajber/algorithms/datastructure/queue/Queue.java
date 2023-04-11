package com.grajber.algorithms.datastructure.queue;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

public interface Queue<T> {

    void enqueue(T element) throws OverflowException;
    T dequeue() throws UnderflowException;

    boolean isEmpty();
}
