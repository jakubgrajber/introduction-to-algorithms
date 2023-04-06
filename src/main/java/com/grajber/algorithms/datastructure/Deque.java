package com.grajber.algorithms.datastructure;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

public interface Deque<T> {

    void enqueueHead(T element) throws OverflowException;
    T dequeueHead() throws UnderflowException;
    void enqueueTail(T element) throws OverflowException;
    T dequeueTail() throws UnderflowException;
    boolean isEmpty();
}
