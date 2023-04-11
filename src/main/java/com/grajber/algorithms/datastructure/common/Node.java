package com.grajber.algorithms.datastructure.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
@Getter
@Setter
public class Node<T> {

    public Node(T data) {
        this.data = data;
    }

    private T data;
    private Node<T> prev;
    private Node<T> next;
}
