package com.grajber.algorithms.datastructure;

import com.grajber.algorithms.datastructure.deque.Deque;
import com.grajber.algorithms.datastructure.deque.FixedSizeDeque;
import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeDequeTest {

    private static final int DEQUE_SIZE = 5;
    private final Deque<Integer> deque = new FixedSizeDeque<>(DEQUE_SIZE);

    @Test
    void enqueueAndDequeAtTheHeadShouldWorkTheSameAsAtTheTail() throws OverflowException, UnderflowException {
       deque.enqueueHead(1);
       assertEquals(1, deque.dequeueHead());

       deque.enqueueTail(2);
       assertEquals(2, deque.dequeueTail());
    }

    @Test
    void enqueueHeadShouldAddElementsAtTheBeginning() throws OverflowException, UnderflowException {
        deque.enqueueHead(1);
        deque.enqueueHead(2);

        assertEquals(2, deque.dequeueHead());
        assertEquals(1, deque.dequeueHead());
    }
}