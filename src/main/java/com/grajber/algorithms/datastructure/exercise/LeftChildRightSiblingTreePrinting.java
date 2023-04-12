package com.grajber.algorithms.datastructure.exercise;

import com.grajber.algorithms.datastructure.tree.binary.LCRSNode;

public class LeftChildRightSiblingTreePrinting {

    public static <T> void print(LCRSNode<T> root) {
        System.out.println(root.data());
        if (root.leftChild() != null) print(root.leftChild());
        if (root.rightSibling() != null) print(root.rightSibling());
    }

    public static void main(String[] args) {
        LCRSNode<Integer> root = new LCRSNode<>(1);
        root.leftChild(new LCRSNode<>(2));
        root.leftChild().rightSibling(new LCRSNode<>(3));
        root.leftChild().rightSibling().rightSibling(new LCRSNode<>(4));

        print(root);
    }
}
