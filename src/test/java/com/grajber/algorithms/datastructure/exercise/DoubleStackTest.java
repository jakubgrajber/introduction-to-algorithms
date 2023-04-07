package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.exception.OverflowException;
import com.grajber.algorithms.datastructure.exception.UnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStackTest {

    private static final int STACK_CAPACITY = 10;
    private final DoubleStack<Integer> doubleStack = new DoubleStack<>(STACK_CAPACITY);

    @Test
    void newlyCreatedStackShouldBeEmpty() {

        assertTrue(doubleStack.isRightEmpty());
        assertTrue(doubleStack.isLeftEmpty());
    }

    @Test
    void shouldBeAbleToPushAndPopAtBothStacks() {

        int leftElement = 1;
        int rightElement = 2;
        doubleStack.pushLeft(leftElement);
        doubleStack.pushRight(rightElement);

        assertEquals(leftElement, doubleStack.popLeft());
        assertEquals(rightElement, doubleStack.popRight());
    }

    @Test
    void shouldThrowStackOverflowException_whenBothStacksTopPointersMeetTogether() {

        doubleStack.pushLeft(0);
        doubleStack.pushLeft(1);
        doubleStack.pushLeft(2);
        doubleStack.pushLeft(3);
        doubleStack.pushLeft(4);

        doubleStack.pushRight(9);
        doubleStack.pushRight(8);
        doubleStack.pushRight(7);
        doubleStack.pushRight(6);
        doubleStack.pushRight(5);

        assertThrows(OverflowException.class, () -> doubleStack.pushLeft(11));
        assertThrows(OverflowException.class, () -> doubleStack.pushRight(11));
    }

}