package com.grajber.algorithms.datastructure;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;
import com.grajber.algorithms.datastructure.queue.FixedSizeQueue;
import com.grajber.algorithms.datastructure.queue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeQueueTest {

    private static final int QUEUE_CAPACITY = 5;
    private final Queue<Integer> queue = new FixedSizeQueue<>(QUEUE_CAPACITY);

    @Test
    void newlyCreatedQueueShouldBeEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldThrowOverflowException_whenCapacityIsReachedAndTriesToEnqueueAnotherElement() throws OverflowException {

       queue.enqueue(1);
       queue.enqueue(2);
       queue.enqueue(3);
       queue.enqueue(4);
       queue.enqueue(5);

       assertThrows(OverflowException.class, () -> queue.enqueue(6));
    }

    @Test
    void shouldBeAbleToDequeueElementsFromQueue() throws UnderflowException, OverflowException {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(4, queue.dequeue());

        queue.enqueue(8);

        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());
        assertEquals(8, queue.dequeue());
    }


}