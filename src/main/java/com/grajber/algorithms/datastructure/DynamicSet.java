package com.grajber.algorithms.datastructure;

public interface DynamicSet<T> {

    Node<T> search(T key);
    void insertAfter(Node<T> node, T key);
    void add(T key);
    void delete(Node<T> node);
}
