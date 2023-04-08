package com.grajber.algorithms.datastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
@Setter
public class Node<T> {

    private final T data;
    private Node<T> prev;
    private Node<T> next;
}
