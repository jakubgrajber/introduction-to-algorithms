package com.grajber.algorithms.datastructure.tree.binary;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 *  Left Child Right Sibling Tree Node Representation
 */
@Getter
@Setter
@Accessors(fluent = true)
public class LCRSNode<T> {

    private T data;
    private LCRSNode<T> leftChild;
    private LCRSNode<T> rightSibling;

    public LCRSNode(T data) {
        this.data = data;
    }
}
