package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.queue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUsingSinglyLinkedListTest {

    private final Queue<Integer> queue = new QueueUsingSinglyLinkedList<>();

    @Test
    void shouldBeAbleToEnqueueAndDequeueElementsInProperOrder() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());
    }

    @Test
    void shouldBeEmptyWhenCreated() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldBeEmptyAfterEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}