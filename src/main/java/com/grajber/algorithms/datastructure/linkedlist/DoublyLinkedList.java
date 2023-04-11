package com.grajber.algorithms.datastructure.linkedlist;

import com.grajber.algorithms.datastructure.common.Node;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DoublyLinkedList<T> implements DynamicSet<T>{

    private Node<T> head;

    @Override
    public Node<T> search(T key) {
        var temp = head;
        while (temp != null && !temp.data().equals(key)) {
            temp = temp.next();
        }
        return temp;
    }

    @Override
    public void insertAfter(Node<T> currentNode, T key) {
        Node<T> insertedNode = new Node<>(key);
        insertedNode.next(currentNode.next());
        insertedNode.prev(currentNode);
        if (currentNode.next() != null)
            currentNode.next().prev(insertedNode);
        currentNode.next(insertedNode);
    }

    @Override
    public void add(T key) {
        Node<T> insertedNode = new Node<>(key);
        if (head == null) {
            head = insertedNode;
            return;
        }

        var temp = head;
        while (temp.next() != null)
            temp = temp.next();
        insertedNode.prev(temp);
        temp.next(insertedNode);
    }

    @Override
    public void delete(Node<T> node) {
        if (node.prev() != null)
            node.prev().next(node.next());
        else
            head = node.next();
        if (node.next() != null)
            node.next().prev(node.prev());
    }
}
