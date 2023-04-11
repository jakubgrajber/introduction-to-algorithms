package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.common.Node;
import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;
import com.grajber.algorithms.datastructure.stack.Stack;

public class StackUsingSinglyLinkedList<T> implements Stack<T> {

    private Node<T> head = null;

    @Override
    public void push(T element) throws OverflowException {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> newlyCreated = new Node<>(element);
            newlyCreated.next(head);
            head = newlyCreated;
        }
    }

    @Override
    public T pop() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        var popped = head;
        head = head.next();
        return popped.data();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
