package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingQueuesTest {

    private static final int STACK_CAPACITY = 5;
    private final Stack<Integer> stack = new StackUsingQueues<>(STACK_CAPACITY);

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