package com.grajber.algorithms.datastructure;

import com.grajber.algorithms.datastructure.exception.StackOverflowException;
import com.grajber.algorithms.datastructure.exception.StackUnderflowException;

public interface Stack<T> {

    void push(T element) throws StackOverflowException;
    T pop() throws StackUnderflowException;
    boolean isEmpty();

}
