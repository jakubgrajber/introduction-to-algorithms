package com.grajber.algorithms.datastructure.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingSinglyLinkedListTest {

    private StackUsingSinglyLinkedList<Integer> stack = new StackUsingSinglyLinkedList<>();

    @Test
    void shouldBeEmptyWhenCreated() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldBeAbleToPushAndPopInTheRightOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());

        stack.push(5);

        assertEquals(5, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void shouldBeEmptyAfterPushAndPop() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

}