package com.grajber.algorithms.datastructure.stack;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;

public interface Stack<T> {

    void push(T element) throws OverflowException;
    T pop() throws UnderflowException;
    boolean isEmpty();

}
