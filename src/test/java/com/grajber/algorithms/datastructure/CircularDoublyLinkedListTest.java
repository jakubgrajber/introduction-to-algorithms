package com.grajber.algorithms.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularDoublyLinkedListTest {

    private final CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();

    @Test
    void shouldBeAbleToAddElement() {

        list.add(2);
        Node<Integer> node = list.search(2);
        assertEquals(2, node.data());
    }

    @Test
    void shouldBeAbleToInsertAtSelectedPlace() {
        list.add(1);
        list.add(2);
        list.add(3);
        Node<Integer> second = list.search(2);
        list.insertAfter(second, 10);
        Node<Integer> third = list.search(10);
        assertEquals(3, third.next().data());
        assertEquals(2, third.prev().data());
    }

    @Test
    void test() {
        list.add(1);
        list.add(2);
        list.add(3);
        Node<Integer> second = list.search(2);
        list.delete(second);
        second = list.search(3);
        assertEquals(1, second.prev().data());
        assertNull(second.next());
    }
}