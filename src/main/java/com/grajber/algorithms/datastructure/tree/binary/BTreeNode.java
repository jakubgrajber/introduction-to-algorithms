package com.grajber.algorithms.datastructure.tree.binary;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class BTreeNode<T> {

    private T data;
    private BTreeNode<T> parent;
    private BTreeNode<T> left;
    private BTreeNode<T> right;

    public BTreeNode(T data) {
        this.data = data;
    }
}
