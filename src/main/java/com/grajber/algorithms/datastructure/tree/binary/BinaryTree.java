package com.grajber.algorithms.datastructure.tree.binary;

import java.util.Stack;

/**
 * Temporary implementation just for exercise purpose.
 * Will be developed later
 */
public class BinaryTree<T> {

    private BTreeNode<T> root;

    public BinaryTree(BTreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printRecursively() {
        printRecursively(root);
    }
    private void printRecursively(BTreeNode<T> current) {
        if (current == null) return;
        System.out.print(current.data() + " ");
        printRecursively(current.left());
        printRecursively(current.right());
    }

    public void printIteratively() {
        if (root == null) return;
        Stack<BTreeNode<T>> stack = new Stack<>();

        BTreeNode<T> current = root;

        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.left();
            }

            current = stack.pop();
            System.out.print(current.data() + " ");

            current = current.right();
        }
    }

    public static void main(String[] args) {
        BTreeNode<Integer> root = new BTreeNode<>(1);
        root.left(new BTreeNode<>(2));
        root.right(new BTreeNode<>(3));
        root.right().left(new BTreeNode<>(4));
        root.right().right(new BTreeNode<>(5));
        root.right().right().right(new BTreeNode<>(6));
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(root);

        integerBinaryTree.printRecursively();
        System.out.println();
        integerBinaryTree.printIteratively();
    }
}
