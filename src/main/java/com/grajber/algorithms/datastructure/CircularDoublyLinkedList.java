package com.grajber.algorithms.datastructure;

public class CircularDoublyLinkedList<T> implements DynamicSet<T>{

    private final Node<T> nil = new Node<>(null);
    public CircularDoublyLinkedList() {
        nil.next(nil);
        nil.prev(nil);
    }

    @Override
    public Node<T> search(T key) {
        nil.data(key);
        var temp = nil.next();
        while (temp.data() != key)
            temp = temp.next();

        nil.data(null);

        if (temp == nil)
            return null;
        else return temp;
    }

    @Override
    public void insertAfter(Node<T> node, T key) {
        Node<T> newlyInserted = new Node<>(key);
        if (node.next() == nil) {
            nil.prev(newlyInserted);
            newlyInserted.next(nil);
        } else {
            newlyInserted.next(node.next());
            newlyInserted.prev(node);
            node.next().prev(newlyInserted);
        }
        node.next(newlyInserted);
    }

    @Override
    public void add(T key) {
        Node<T> newlyInserted = new Node<>(key);
        if (nil.next() == nil){
            nil.next(newlyInserted);
            nil.prev(newlyInserted);
            newlyInserted.prev(nil);
            newlyInserted.next(nil);
            return;
        }

        var temp = nil.next();
        while (temp.next() != nil)
            temp = temp.next();
        temp.next(newlyInserted);
        newlyInserted.prev(temp);
        newlyInserted.next(nil);
        nil.prev(newlyInserted);
    }

    @Override
    public void delete(Node<T> node) {
        node.prev().next(node.next());
        node.next().prev(node.prev());
    }
}
